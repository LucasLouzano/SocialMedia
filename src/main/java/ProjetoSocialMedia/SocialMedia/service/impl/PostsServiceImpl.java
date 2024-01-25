package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.repository.PostsRepository;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsRepository postRepository;
    @Override
    public List<Posts> findALL() {
        return postRepository.findAll();
    }
    @Override
    public Posts findById(Long postId) {
        Optional<Posts> posts = postRepository.findById(postId);
        return posts.orElse(null);
    }

    @Override
    public Posts save(Posts post) {
        postRepository.save(post);
        return post;
    }

    @Override
    public Posts update(Posts updatePost) {
        updatePost.setTexto(updatePost.getTexto());
        updatePost.setAuthor(updatePost.getAuthor());
        updatePost.setCreateDateTime(updatePost.getCreateDateTime());
        updatePost.setComments(updatePost.getComments());
        postRepository.save(updatePost);
        return updatePost;
    }

    @Override
    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }

}


