package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.Post;
import ProjetoSocialMedia.SocialMedia.service.UserSocialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("users")
public class UserSocialController {

    @Autowired
    private UserSocialService userSocialService;
    @GetMapping
    public ResponseEntity getUsers() {
        List<Post> UsersList = this.userSocialService.findAll()
                .stream().map(Post::new).toList();

        return ResponseEntity.ok(UsersList);
    }

    @PostMapping
    public ResponseEntity<String> saveUsers(@RequestBody @Valid Post users)  {
        Post userSocial = new Post(users);

        this.userSocialService.save(userSocial);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id) {
        this.userSocialService.deleteById(id);
    }

}