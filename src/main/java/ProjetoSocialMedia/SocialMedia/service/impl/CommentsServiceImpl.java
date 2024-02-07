package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.model.comment.Comments;
import ProjetoSocialMedia.SocialMedia.repository.CommentsRepository;
import ProjetoSocialMedia.SocialMedia.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public List<Comments> findAll() {
        return commentsRepository.findAll();
    }

    @Override
    public Comments findById(Long id) {
        Optional<Comments> commentsOptional = commentsRepository.findById(id);
        return commentsOptional.orElse(null);
    }

    @Override
    public Comments save(Comments comments) {
        return commentsRepository.save(comments);
    }

    @Override
    public Comments update(Long id, Comments comments) {
        Optional<Comments> commentsOptional = commentsRepository.findById(id);
        if (commentsOptional.isPresent()) {
            comments.setId(comments.getId());
            comments.setMessage(comments.getMessage());
            comments.setAuthor(comments.getAuthor());
            comments.setCreateDateTime(comments.getCreateDateTime());
        }
        return commentsRepository.save(comments);
    }

    @Override
    public boolean deleteById(Long id) {
      commentsRepository.deleteById(id);
      return false;
    }
}