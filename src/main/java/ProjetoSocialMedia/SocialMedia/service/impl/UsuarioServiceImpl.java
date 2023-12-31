package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.model.Usuario;
import ProjetoSocialMedia.SocialMedia.repository.UsuarioRepository;
import ProjetoSocialMedia.SocialMedia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario create(Usuario indentificacao) {
        if (indentificacao != null) {
            this.usuarioRepository.save(indentificacao);
        }
        return indentificacao;
    }

    @Override
    public Usuario update(Long id, Usuario indentificacao) {
        return null;
    }

    @Override
    public int deleteByid(Long id) {
        return 0;
    }
}
