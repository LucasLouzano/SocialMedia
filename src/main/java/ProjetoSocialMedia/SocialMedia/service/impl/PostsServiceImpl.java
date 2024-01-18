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
        if (post != null) {
            postRepository.save(post);
        }
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
    public Posts update(Long id, Posts PostId) {
        Posts existingPost = findById(id);
        if (existingPost != null) {
            existingPost.setTexto(PostId.getTexto());
            existingPost.setAuthor(PostId.getAuthor());
            existingPost.setCreateDateTime(PostId.getCreateDateTime());
            existingPost.setComments(PostId.getComments());
            postRepository.save(existingPost);
        }
        return existingPost;
    }

    @Override
    public void deleteById(Long postId) {
        postRepository.deleteById(postId);
    }
}


