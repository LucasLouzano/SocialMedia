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

    public Usuario findById(Long id) {
        Optional<Usuario> Indentificacao = usuarioRepository.findById(id);
        return Indentificacao.orElseThrow(null);//-> new RuntimeException(
              //  "Indentificacao não encontrado! id:" + id + ",Tipo:" + Usuario.class.getName()));
    }

    public List<Usuario> findAll(boolean usuarioAutenticado) {
        if (!usuarioAutenticado) {
            throw new RuntimeException("Usuário não tem permição para listar usuário");
        }
        return usuarioRepository.findAll();
    }
    public Usuario update(Long id, Usuario Indentificacao) {
        Usuario newIndentificacao = findById(id);
        newIndentificacao.setNome(Indentificacao.getNome());
        newIndentificacao.setLogin(Indentificacao.getLogin());
        newIndentificacao.setSenha(Indentificacao.getSenha());
        return usuarioRepository.save(newIndentificacao);
    }

    public Usuario create(Usuario indentificacao) {
        indentificacao.setId(null);
        return usuarioRepository.save(indentificacao);
    }
    public void delete(Long id) {
        findById(id);
        usuarioRepository.deleteById(id);
    }

}
