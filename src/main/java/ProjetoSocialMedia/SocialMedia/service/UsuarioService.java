package ProjetoSocialMedia.SocialMedia.service;
import ProjetoSocialMedia.SocialMedia.model.Usuario;
import ProjetoSocialMedia.SocialMedia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario create(Usuario indentificacao) {
        if (indentificacao != null) {
          this.usuarioRepository.save(indentificacao);
        }
        return indentificacao;
    }
}




