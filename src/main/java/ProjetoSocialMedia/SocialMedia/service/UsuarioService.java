package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.model.Usuario;
import ProjetoSocialMedia.SocialMedia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario create(Usuario indentificacao) {
        indentificacao.setId(null);
        return usuarioRepository.save(indentificacao);
    }

}
