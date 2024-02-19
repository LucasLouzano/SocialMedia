package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
import io.swagger.v3.oas.annotations.Operation;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostsService postService;

    @Operation(summary = "Listar", description = "Método que retorna todos os dados")
    @GetMapping
    public ResponseEntity<List<PostsDTO>> GetPosts() {
        List<PostsDTO> postsListDTO = postService.findAll();
        if (postsListDTO.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postsListDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Posts> getPostById(@PathVariable Long id) {
        Posts post = postService.findById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<PostsDTO> savePosts(@RequestBody Posts posts) {
        PostsDTO postsDTO = postService.save(posts);
        return ResponseEntity.ok(postsDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Posts> atualizar(@PathVariable Long id, @RequestBody @Valid Posts updatePost) {
        updatePost.setId(id);
        Posts postagens = postService.update(updatePost);
        if (postagens == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(postagens);
    }



    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        boolean deleted = postService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(deleted);
        }
    }
    @GetMapping("/comments")
    public ResponseEntity<List<Posts>> getAllPostsWithComments() {
        List<Posts> postsComments = postService.findAllPostsWithComments(); // ENCONTRAR TODAS AS POSTAGENS COM COMENTÁRIO
        return ResponseEntity.ok(postsComments);
    }
}