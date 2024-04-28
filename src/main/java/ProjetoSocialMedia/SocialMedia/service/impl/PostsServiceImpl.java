package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.mapper.PostsMapper;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.repository.PostsRepository;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsRepository postRepository;
    @Autowired
    private PostsMapper postsMapper;

    @Override
    public List<Posts> findAllPostsWithComments() {
        List<Posts> posts = postRepository.findAll();
        posts.forEach(post -> post.setComments(post.getComments()));
        return posts;
    }

    @Override
    public PostsDTO findById(Long id) {
        Posts posts = postRepository.findById(id).get();
        return postsMapper.postsToPostsDTO(posts);
    }

    @Override
    public PostsDTO update(Posts updatePost) {
        Posts posts = postRepository.save(updatePost);
        return postsMapper.postsToPostsDTO(posts);
    }

    @Override
    public PostsDTO delete(Long id) {
        Posts posts = postRepository.findById(id).get();
        postRepository.delete(posts);
        return postsMapper.postsToPostsDTO(posts);
    }
}



