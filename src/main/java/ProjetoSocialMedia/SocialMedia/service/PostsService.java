package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.postdto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.model.Posts;

import java.util.List;

public interface PostsService {

//    PostsDTO findById(Long id);

//    PostsDTO update(Posts updatePost);

    PostsDTO delete(Long id);

    List<Posts> findAllPostsWithComments();
}
