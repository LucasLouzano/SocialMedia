package ProjetoSocialMedia.SocialMedia.repository;

import ProjetoSocialMedia.SocialMedia.model.users.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findByLogin(String login);

}
