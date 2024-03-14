package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.mapper.PostsMapper;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.repository.PostsRepository;
import ProjetoSocialMedia.SocialMedia.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostsServiceImpl implements PostsService {
    @Autowired
    private PostsRepository postRepository;

    @Autowired
    private PostsMapper postsMapper;

    @Override
    public List<PostsDTO> findAll() {
        return postRepository.findAll()
                .stream()
                .map(postsMapper::postsToPostsDTO).collect(Collectors.toList());
    }

    @Override
    public List<Posts> findAllPostsWithComments() {
        List<Posts> posts = postRepository.findAll();
        posts.forEach(post -> post.setComments(post.getComments()));
        return posts;
    }

    @Override
    public Posts findById(Long id) {
        Optional<Posts> posts = postRepository.findById(id);
        return posts.orElse(null);
    }

    @Override
    public Posts save(String text) {
    	Posts post = new Posts();
    	post.setTexto(text);
        post.setCreateDateTime(LocalDateTime.now());
        //TODO set author
        return postRepository.save(post);
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
    public Posts delete(Long id) {
        Optional<Posts> postsOptional = postRepository.findById(id);
        if (postsOptional.isPresent()) {
            Posts postsDelete = postsOptional.get();
            postRepository.delete(postsDelete);
            return postsDelete;
        } else {
            return null;
        }
    }
}




