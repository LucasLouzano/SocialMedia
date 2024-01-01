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
    public Optional<Usuario> getBuscaUsuarioPorId(Long id) {
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
        Optional<Usuario> usuarios = usuarioRepository.findById(id);
        if(usuarios.isPresent()) {
            usuarios.get().setNome(indentificacao.getNome());
            usuarios.get().setLogin(indentificacao.getLogin());
            usuarios.get().setPassword(indentificacao.getPassword());
            return usuarios.get();
        }
        return null;
    }

    @Override
    public void deleteByid(Long id) {
        usuarioRepository.deleteById(id);
    }
}
