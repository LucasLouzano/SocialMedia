package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;

import java.util.List;

public interface PostsService {

    Posts findById(Long postId);

    Posts save(Posts post);

    Posts update(Posts updatePost);

    void deleteById(Long postId);

    List<Posts> findALL();

}
