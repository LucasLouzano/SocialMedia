package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
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

    @GetMapping()
    public ResponseEntity<List<Posts>> getAllPosts() {
        List<Posts> PostsList = postService.findAllByOrderByCreateDateTimeDesc();
        return ResponseEntity.ok(PostsList);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Posts> getPostById(@PathVariable Long postId) {
        Posts posts = postService.findById(postId);
        return ResponseEntity.ok(posts);
    }

    @PostMapping
    public ResponseEntity<String> savePosts(@RequestBody @Valid Posts posts) {
        Posts postagem = new Posts(posts);

        this.postService.save(postagem);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Posts> atualizar(@PathVariable Long id, @RequestBody @Valid Posts PostId) {
        Posts postagens = postService.update(id, PostId);
        return ResponseEntity.ok().body(postagens);
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        this.postService.deleteById(postId);
        return ResponseEntity.ok("Posts deleted successwfully");
    }

}