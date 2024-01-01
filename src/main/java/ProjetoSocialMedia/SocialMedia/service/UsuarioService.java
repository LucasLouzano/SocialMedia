package ProjetoSocialMedia.SocialMedia.service;
import ProjetoSocialMedia.SocialMedia.model.Usuario;

import java.util.List;
import java.util.Optional;


public interface UsuarioService {
    List<Usuario> findAll();

    Optional<Usuario> getBuscaUsuarioPorId(Long id);

    Usuario create(Usuario indentificacao);

    Usuario update(Long id, Usuario indentificacao);

    void deleteByid(Long id);


}




