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
    public Posts update(Long id, Posts posts) {
        Posts postage = findById(id);
        postage.setTexto(posts.getTexto());
        postage.setAuthor(posts.getAuthor());
        postage.setCreateDateTime(posts.getCreateDateTime());
        postage.setComments(posts.getComments());
        postRepository.save(postage);
        return postage;
    }

    @Override
    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }

}


