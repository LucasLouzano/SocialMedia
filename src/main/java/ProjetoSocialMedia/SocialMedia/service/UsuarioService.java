package ProjetoSocialMedia.SocialMedia.service;
import ProjetoSocialMedia.SocialMedia.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UsuarioService {
    List<Usuario> findAll();

    Optional<Usuario> findById(Long id);

    Usuario create(Usuario indentificacao);

    Usuario update(Long id, Usuario indentificacao);

    int deleteByid(Long id);


}




