package ProjetoSocialMedia.SocialMedia.repository;
import ProjetoSocialMedia.SocialMedia.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

}
