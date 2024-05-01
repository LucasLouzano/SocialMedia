package ProjetoSocialMedia.SocialMedia.controller;

import java.util.List;

import ProjetoSocialMedia.SocialMedia.api.PostApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "*") // qualquer dominuin acesse essa api *
public class PostsController {
    @Autowired
    private PostsService postService;
    @Autowired
    private PostApi postApi;

    @Operation(summary = "Obter todos os posts", description = "Retorna uma lista de todos os posts.")
    @GetMapping
    public ResponseEntity<List<PostsDTO>> getPosts() {
        List<PostsDTO> postsListDTO = postApi.findAll();
        if (postsListDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postsListDTO);
    }

    @Operation(summary = "Obter um post por ID", description = "Retorna um post específico com base no ID fornecido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post encontrado"),
            @ApiResponse(responseCode = "404", description = "Post não encontrado")})
    @GetMapping("/{id}")
    public ResponseEntity<PostsDTO> getPostById(@Parameter(description = "ID do post a ser encontrado", example = "1") @PathVariable Long id) {
        PostsDTO postsDTO = postApi.findById(id);
        if (postsDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postsDTO);
    }

    @Operation(summary = "Salvar um novo post", description = "Salva um novo post.")
    @PostMapping()
    public ResponseEntity<PostsDTO> savePosts(@RequestBody @Valid Posts posts) {
        PostsDTO postsDTO = postApi.save(posts);
        if (postsDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postsDTO);
    }

    @Operation(summary = "Atualizar um post existente", description = "Atualiza um post existente com base no ID fornecido.")
    @PutMapping(value = "/{id}")
    public ResponseEntity<PostsDTO> atualizar(@PathVariable @RequestBody @Valid Posts Posts) {
        PostsDTO postsDTO = postApi.update(Posts);
        if (postsDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(postsDTO);
    }


    @Operation(summary = "Deletar um post", description = "Deleta um post com base no ID fornecido.")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PostsDTO> deletePost(@PathVariable Long id) {
        PostsDTO postagens = postService.delete(id);
        if (postagens == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postagens);
    }

    @Operation(summary = "Obter todos os posts com comentários", description = "Retorna uma lista de todos os posts que possuem comentários.")
    @GetMapping("/comments")
    public ResponseEntity<List<Posts>> getAllPostsWithComments() {
        List<Posts> postsComments = postService.findAllPostsWithComments(); // ENCONTRAR TODAS AS POSTAGENS COM COMENTÁRIO
        return ResponseEntity.ok(postsComments);
    }
}