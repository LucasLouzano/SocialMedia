package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.comment.Comments;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postService;

    @GetMapping()
    public ResponseEntity<List<Posts>> getAllPosts() {
        List<Posts> postsList = postService.findAllByOrderByCreateDateTimeDesc();
        if (postsList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postsList);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Posts> getPostById(@PathVariable Long postId) {
        Posts post = postService.findById(postId);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }


    @PostMapping
    public ResponseEntity<String> savePosts(@RequestBody @Valid Posts posts) {
        Posts postagem = new Posts(posts);
        if (postagem == null) {
            return ResponseEntity.notFound().build();
        }
        this.postService.save(postagem);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<String> adicionarCommet(@PathVariable Long postId, @RequestBody @Valid Comments comments) {
            Posts post = postService.findById(postId);
            if (post == null) {
                return ResponseEntity.notFound().build();
            }
            comments.setPosts(post);
            post.addComment(comments);
            postService.save(post);

            return ResponseEntity.ok("Comentário adicionado com sucesso");


    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Posts> atualizar(@PathVariable Long id, @RequestBody @Valid Posts updatePost) {
        Posts postagens = postService.update(id, updatePost);
        if (postagens == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(postagens);
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        this.postService.deleteById(postId);
        if (postId != null) {
            return ResponseEntity.ok("Posts deleted successwfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}