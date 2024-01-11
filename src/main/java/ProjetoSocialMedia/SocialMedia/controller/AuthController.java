package ProjetoSocialMedia.SocialMedia.controller;
import ProjetoSocialMedia.SocialMedia.dto.Login;
import ProjetoSocialMedia.SocialMedia.model.Usuario;
import ProjetoSocialMedia.SocialMedia.repository.UsuarioRepository;
import ProjetoSocialMedia.SocialMedia.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login) throws AuthenticationException {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.login(), login.password());

        Authentication authenticate = this.authenticationManager
                .authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Usuario) authenticate.getPrincipal();

        String token = tokenService.gerarToken(usuario);
        return ResponseEntity.ok(token);
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
        if (usuario.getLogin() == null || usuario.getPassword() == null) {
            return ResponseEntity.badRequest().body("Login e senha são obrigatórios para registro.");
        }
        if (usuarioRepository.findByLogin(usuario.getLogin()) != null) {
            return ResponseEntity.badRequest().body("Usuário com este login já existe.");
        }
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso!");
    }

}

//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
//        System.out.println("Login: " + usuario.getLogin());
//        System.out.println("Password: " + usuario.getPassword());
//
//        if (usuario.getLogin() == null || usuario.getPassword() == null) {
//            return ResponseEntity.badRequest().body("Login e senha são obrigatórios para registro.");
//        }
//        if (usuarioRepository.findByLogin(usuario.getLogin()) != null) {
//            return ResponseEntity.badRequest().body("Usuário com este login já existe.");
//        }
//        usuarioRepository.save(usuario);
//        return ResponseEntity.status(HttpStatus.CREATED).body("Usuário registrado com sucesso!");
//    }
//
//}
//
//
