package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.model.posts.Post;

import java.util.List;

public interface PostService {
    void save(Post userSocial) ;

    List<Post> findAll();

    void deleteById(Long id);
}
