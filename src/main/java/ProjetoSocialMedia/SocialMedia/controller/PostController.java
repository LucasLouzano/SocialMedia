package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.posts.Post;
import ProjetoSocialMedia.SocialMedia.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;
    @GetMapping
    public ResponseEntity getPosts() {
        List<Post> PostsList = this.postService.findAll()
                .stream().map(Post::new).toList();

        return ResponseEntity.ok(PostsList);
    }

    @PostMapping
    public ResponseEntity<String> savePosts(@RequestBody @Valid Post posts)  {
        Post userSocial = new Post(posts);

        this.postService.save(userSocial);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/posts/{id}")
    public void delete(@PathVariable Long id) {
        this.postService.deleteById(id);
    }

}