package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;

import java.util.List;

public interface PostsService {

    Posts findById(Long id);

    Posts save(Posts post);

    Posts update(Posts updatePost);

    void delete(Long id);

    List<Posts> findALL();

}
