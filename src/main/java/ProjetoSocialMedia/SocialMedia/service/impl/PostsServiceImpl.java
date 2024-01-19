package ProjetoSocialMedia.SocialMedia.service.impl;

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

    @Override
    public void save(Posts post) {
        postRepository.save(post);
    }


    @Override
    public List<Posts> findAllByOrderByCreateDateTimeDesc() {
        return postRepository.findAllByOrderByCreateDateTimeDesc();
    }


    @Override
    public Posts findById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public Posts update(Long id, Posts updatePost) {
        Posts existingPost = findById(id);
        existingPost.setTexto(updatePost.getTexto());
        existingPost.setAuthor(updatePost.getAuthor());
        existingPost.setCreateDateTime(updatePost.getCreateDateTime());
        existingPost.setComments(updatePost.getComments());
        postRepository.save(existingPost);
        return existingPost;
    }

    @Override
    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }
}


