package ProjetoSocialMedia.SocialMedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
import jakarta.validation.Valid;

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

    @GetMapping("/{id}")
    public ResponseEntity<Posts> getPostById(@PathVariable Long id) {
        Posts post = postService.findById(id);
        if (post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    //TODO não precisa de um DTO?
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


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = postService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Posts>> getAllPostsWithComments() {
        List<Posts> postsComments = postService.findAllPostsWithComments(); // ENCONTRAR TODAS AS POSTAGENS COM COMENTÁRIO
        return ResponseEntity.ok(postsComments);
    }
}