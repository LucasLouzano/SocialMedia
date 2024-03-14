package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;

import java.util.List;

public interface PostsService {
    List<PostsDTO> findAll();

    Posts findById(Long id);

    Posts save(String text);

    Posts update(Posts updatePost);

    Posts delete(Long id);

    List<Posts> findAllPostsWithComments();
}
