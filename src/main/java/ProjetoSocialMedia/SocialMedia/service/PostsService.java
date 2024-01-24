package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;

import java.util.List;

public interface PostsService {
//    List<Posts> findAllByOrderByCreateDateTimeDesc();

    //    Posts findById(Long postId);
    Posts findById(Long postId);

    Posts save(Posts post);

    Posts update(Long id, Posts PostId);

    void deleteById(Long postId);

    List<Posts> findALL();

}
