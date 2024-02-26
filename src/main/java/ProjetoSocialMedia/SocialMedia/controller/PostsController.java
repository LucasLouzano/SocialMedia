package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/posts")
@Api(value = "API REST POSTS")
@CrossOrigin(origins = "*") // qualquer dominuin acesse essa api *
public class PostsController {
    @Autowired
    private PostsService postService;

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de posts")
    public ResponseEntity<List<PostsDTO>> GetPosts() {
        List<PostsDTO> postsListDTO = postService.findAll();
        if (postsListDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postsListDTO);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um posts único")
    public ResponseEntity<Posts> getPostById(@PathVariable Long id) {
        Posts post = postService.findById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @PostMapping
    @ApiOperation(value = "Salva um posts")
    public ResponseEntity<PostsDTO> savePosts(@RequestBody Posts posts) {
        PostsDTO postsDTO = postService.save(posts);
        return ResponseEntity.ok(postsDTO);
    }

    @PutMapping(value = "/{id}")
    @ApiOperation(value = "Atualiza um posts")
    public ResponseEntity<Posts> atualizar(@PathVariable Long id, @RequestBody @Valid Posts updatePost) {
        updatePost.setId(id);
        Posts postagens = postService.update(updatePost);
        if (postagens == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(postagens);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "Delata um posts")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        Posts posts = postService.delete(id);
        if (posts != null) {
            return ResponseEntity.ok().body("Posts com ID " + id + " foi deletado com sucesso !");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/comments")
    @ApiOperation(value = "Retorna e busca todos os comentarios de um posts")
    public ResponseEntity<List<Posts>> getAllPostsWithComments() {
        List<Posts> postsComments = postService.findAllPostsWithComments(); // ENCONTRAR TODAS AS POSTAGENS COM COMENTÁRIO
        return ResponseEntity.ok(postsComments);
    }
}