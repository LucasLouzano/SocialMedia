package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;

import java.util.List;

public interface PostsService {
    Posts save(Posts post);
    List<Posts> findAllByOrderByCreateDateTimeDesc();

    Posts findById(Long postId);
//    Optional findById(Long postId);

    Posts update(Long id, Posts PostId);

    void deleteById(Long postId);

}
