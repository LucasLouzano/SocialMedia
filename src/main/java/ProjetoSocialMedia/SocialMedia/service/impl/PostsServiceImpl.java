package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.model.comment.Comments;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.repository.CommentsRepository;
import ProjetoSocialMedia.SocialMedia.repository.PostsRepository;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsRepository postRepository;
    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public List<Posts> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Posts findById(Long id) {
        Optional<Posts> posts = postRepository.findById(id);
        return posts.orElse(null);
    }

    @Override
    public Posts save(Posts post) {
        if (post != null) {
            postRepository.save(post);
        }
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
    public void delete(Long id) {
        findById(id);
        postRepository.deleteById(id);
    }

}


