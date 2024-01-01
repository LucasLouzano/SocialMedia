package ProjetoSocialMedia.SocialMedia.controller;
import ProjetoSocialMedia.SocialMedia.model.Usuario;
import ProjetoSocialMedia.SocialMedia.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> listUsuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(listUsuarios);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> find(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.getBuscaUsuarioPorId(id);
        return usuario
            .map(use -> ResponseEntity.ok().body(use)) // Retorna o usuário se presente
            .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se ausente
        
    }

    @PostMapping()
    public ResponseEntity<Usuario> create(@RequestBody Usuario indentificacao) {
        Usuario newIndentificacao = usuarioService.create(indentificacao);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newIndentificacao.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    @PutMapping()
    public ResponseEntity <Usuario> update(Long id, @RequestBody Usuario Indentificacao){
        Usuario usuario = usuarioService.create(Indentificacao);
        return ResponseEntity.ok().body(usuario);
    }


    @DeleteMapping("/{id}")
    public void deleteByid(@PathVariable("id") Long id) {
        usuarioService.deleteByid(id);
    }
}