package ProjetoSocialMedia.SocialMedia.repository;

import ProjetoSocialMedia.SocialMedia.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserSocialRepository extends JpaRepository<Post, Long> {

}


