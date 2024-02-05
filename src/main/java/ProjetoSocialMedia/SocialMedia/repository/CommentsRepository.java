package ProjetoSocialMedia.SocialMedia.repository;

import ProjetoSocialMedia.SocialMedia.model.comment.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
}
