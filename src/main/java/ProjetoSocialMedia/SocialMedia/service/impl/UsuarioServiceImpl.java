package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.model.Usuario;
import ProjetoSocialMedia.SocialMedia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public void salvarUsuario(Usuario newUsuario) {
        if (newUsuario != null) {
            this.usuarioRepository.save(newUsuario);
        }
    }

    public Usuario atualizar(Long id, Usuario usuario) {
        Optional<Usuario> usuarios = usuarioRepository.findById(id);
        if (usuarios.isPresent()) {
            usuarios.get().setLogin(usuario.getLogin());
            usuarios.get().setPassword(usuario.getPassword());
            return usuarios.get();
        }
        return null;
    }

    public void deleteByid(Long id) {
        usuarioRepository.deleteById(id);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(username);
    }
}