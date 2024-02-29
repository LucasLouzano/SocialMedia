package ProjetoSocialMedia.SocialMedia.repository;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

}


