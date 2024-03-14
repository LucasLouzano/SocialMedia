package ProjetoSocialMedia.SocialMedia.controller;

import java.util.List;

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

import ProjetoSocialMedia.SocialMedia.dto.PostDTORequestSave;
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
    @Operation(summary = "Obter todos os posts", description = "Retorna uma lista de todos os posts.")
    @GetMapping
    public ResponseEntity<List<PostsDTO>> GetPosts() {
        List<PostsDTO> postsListDTO = postService.findAll();
        if (postsListDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postsListDTO);
    }
    // Endpoint para obter um post por ID
    @Operation(summary = "Obter um post por ID", description = "Retorna um post específico com base no ID fornecido.")
    @ApiResponses(value = { // é usada para fornecer informações sobre as possíveis respostas que um endpoint pode retornar. Ela permite especificar uma lista de respostas HTTP
            @ApiResponse(responseCode = "200", description = "Post encontrado"),
            @ApiResponse(responseCode = "404", description = "Post não encontrado")
//          responseCode indica o status da resposta HTTP endpoint
//          description Uma explicação detalhada da funcionalidade do endpoint.
    })
    @GetMapping("/{id}")
    public ResponseEntity<Posts> getPostById(@Parameter(description = "ID do post a ser encontrado", example = "1") @PathVariable Long id) {
        Posts post = postService.findById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    //TODO não precisa de um DTO?
    @Operation(summary = "Salvar um novo post", description = "Salva um novo post.")
    @PostMapping
    public ResponseEntity<Posts> savePosts(@RequestBody PostDTORequestSave post) {
    	
        Posts postsDTO = postService.save(post.text());
        return ResponseEntity.ok(postsDTO);
    }
    @Operation(summary = "Atualizar um post existente", description = "Atualiza um post existente com base no ID fornecido.")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Posts> atualizar(@PathVariable Long id, @RequestBody @Valid Posts updatePost) {
        updatePost.setId(id);
        Posts postagens = postService.update(updatePost);
        if (postagens == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(postagens);
    }
    @Operation(summary = "Deletar um post", description = "Deleta um post com base no ID fornecido.")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Posts posts = postService.delete(id);
        if (posts != null) {
            return ResponseEntity.ok().body("Posts com ID " + id + " foi deletado com sucesso !");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Obter todos os posts com comentários", description = "Retorna uma lista de todos os posts que possuem comentários.")
    @GetMapping("/comments")
    public ResponseEntity<List<Posts>> getAllPostsWithComments() {
        List<Posts> postsComments = postService.findAllPostsWithComments(); // ENCONTRAR TODAS AS POSTAGENS COM COMENTÁRIO
        return ResponseEntity.ok(postsComments);
    }
}