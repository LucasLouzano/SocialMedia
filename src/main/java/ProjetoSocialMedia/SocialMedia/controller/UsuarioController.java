package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.Usuario;
import ProjetoSocialMedia.SocialMedia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario indentificacao = this.usuarioService.findById(id);
        return ResponseEntity.ok().body(indentificacao);
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> findAll() {
        boolean usuarioAutenticado = true;
        List<Usuario> listUsuarios = usuarioService.findAll(usuarioAutenticado);
        return ResponseEntity.ok().body(listUsuarios);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario Indentificacao) {
        Usuario newIndentificancao = usuarioService.update(id, Indentificacao);
        return ResponseEntity.ok().body(newIndentificancao);
    }
    @PostMapping()
    public ResponseEntity<Usuario> create (@RequestBody Usuario ndentificacao) {
        Usuario newIndentificacao = usuarioService.create(ndentificacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newIndentificacao.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity <Void> delete(@PathVariable Long id) {
        usuarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}