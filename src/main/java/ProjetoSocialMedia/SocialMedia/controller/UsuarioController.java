package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.Usuario;

import ProjetoSocialMedia.SocialMedia.service.impl.UsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuario() {
        List<Usuario> listUsuarios = usuarioService.findAll()
                .stream().map(Usuario::new).toList();
        return ResponseEntity.ok(listUsuarios);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody @Valid Usuario usuario) {
        Usuario newUsuario = new Usuario(usuario);

        this.usuarioService.salvarUsuario(newUsuario);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users")
    public ResponseEntity<Usuario> update(Long id, @RequestBody Usuario usuario) {
        Usuario usuarios = usuarioService.atualizar(id, usuario);
        return ResponseEntity.ok().body(usuarios);
    }

    @DeleteMapping("/{id}")
    public void deleteByid(@PathVariable("id") Long id) {
        usuarioService.deleteByid(id);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Usuario> find(@PathVariable Long id) {
//        Optional<Usuario> usuario = usuarioService.getBuscaUsuarioPorId(id);
//        return usuario
//                .map(use -> ResponseEntity.ok().body(use)) // Retorna o usuário se presente
//                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se ausente
//    }

//    @PostMapping()
//    public ResponseEntity<Usuario> create(@RequestBody Usuario indentificacao) {
//        Usuario newIndentificacao = usuarioService.create(indentificacao);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(newIndentificacao.getId())
//                .toUri();
//        return ResponseEntity.created(uri).build();
//    }
}


