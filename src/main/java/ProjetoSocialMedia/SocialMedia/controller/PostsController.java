package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.comment.Comments;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postService;

    @GetMapping
    public ResponseEntity<List<Posts>> GetPosts() {
        List<Posts> postsList = postService.findAll();
        if (postsList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postsList);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Posts> getPostById(@PathVariable Long id) {
        Posts post = postService.findById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public ResponseEntity<String> savePosts(@RequestBody @Valid Posts posts) {
        Posts postagem = new Posts(posts);
        this.postService.save(postagem);
        return ResponseEntity.ok().build();
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


    @DeleteMapping("/{postId}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.postService.delete(id);
        if (id != null) {
            return ResponseEntity.ok("Post deletado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}