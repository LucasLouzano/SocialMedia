package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
//
//    @GetMapping("/{postId}")
//    public ResponseEntity<Posts> getPostById(@PathVariable Long postId){
//        Optional<Posts> optionalPosts = postService.findById(postId);
//        if (optionalPosts.isPresent()){
//            Posts posts = optionalPosts.get();
//            return ResponseEntity.ok(posts);
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//    }

    @PostMapping
    public ResponseEntity<String> savePosts(@RequestBody @Valid Posts posts) {
        Posts postagem = new Posts(posts);
        if (postagem == null) {
            return ResponseEntity.notFound().build();
        }
        this.postService.save(postagem);
        return ResponseEntity.ok().build();
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