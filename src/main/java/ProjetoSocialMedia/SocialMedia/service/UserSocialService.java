package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.model.Post;

import java.util.List;

public interface UserSocialService {
    void save(Post userSocial) ;

    List<Post> findAll();

    void deleteById(Long id);
}
