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

    @GetMapping()
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> listUsuarios = usuarioService.findAll();
        return ResponseEntity.ok().body(listUsuarios);
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
}