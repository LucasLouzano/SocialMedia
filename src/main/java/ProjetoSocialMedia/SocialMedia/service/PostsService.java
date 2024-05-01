package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;

import java.util.List;

public interface PostsService {

//    PostsDTO findById(Long id);

//    PostsDTO update(Posts updatePost);

    PostsDTO delete(Long id);

    List<Posts> findAllPostsWithComments();
}
