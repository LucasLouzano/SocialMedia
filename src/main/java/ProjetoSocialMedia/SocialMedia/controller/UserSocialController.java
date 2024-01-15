package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.UserSocial;
import ProjetoSocialMedia.SocialMedia.repository.UserSocialRepository;
import ProjetoSocialMedia.SocialMedia.service.UserSocialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("product")
public class UserSocialController {

    @Autowired
    private UserSocialService userSocialService;

    @PostMapping
    public ResponseEntity<String> saveUsers(@RequestBody @Valid UserSocial users) {
        UserSocial userSocial = new UserSocial(users);

        this.userSocialService.save(userSocial);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getUsers() {
        List<UserSocial> UsersList = this.userSocialService.findAll()
                .stream().map(UserSocial::new).toList();

        return ResponseEntity.ok(UsersList);
    }

    @DeleteMapping("/product/{id}")
    public void delete(@PathVariable Long id) {
        this.userSocialService.deleteById(id);
    }

}