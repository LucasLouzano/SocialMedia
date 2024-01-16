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

    @GetMapping("/posts")
    public ResponseEntity<List<Posts>> getAllPosts() {
        List<Posts> PostsList = postService.findAllByOrderByCreateDateTimeDesc();
        return ResponseEntity.ok(PostsList);
    }

    @GetMapping("/{postsId}")
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
    public ResponseEntity<Posts> atualizar(@PathVariable Long Id, @RequestBody @Valid Posts PostId) {
        Posts existingPost = postService.update(Id, PostId);
        return ResponseEntity.ok().body(existingPost);
    }


    @DeleteMapping("/{postsId}")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        this.postService.deleteById(postId);
        return ResponseEntity.ok("Posts deleted successwfully");
    }

}