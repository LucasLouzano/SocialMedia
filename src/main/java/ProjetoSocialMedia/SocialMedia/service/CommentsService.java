package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.model.comment.Comments;


import java.util.List;

public interface CommentsService {
    Comments findById(Long id);

    List<Comments> findAll();

    Comments save(Comments comments);

    Comments update(Long id, Comments comments);

    boolean deleteById(Long id);
}
