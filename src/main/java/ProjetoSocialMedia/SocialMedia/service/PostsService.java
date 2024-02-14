package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;

import java.util.List;

public interface PostsService {

    Posts findById(Long id);

    PostsDTO save(Posts posts);

    Posts update(Posts updatePost);

    boolean delete(Long id);

    List<PostsDTO> findAll();

    List<Posts> findAllPostsWithComments();
}
