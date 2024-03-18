package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.dto.Login;
import ProjetoSocialMedia.SocialMedia.dto.RegisterDTO;
import ProjetoSocialMedia.SocialMedia.model.users.Usuario;
import ProjetoSocialMedia.SocialMedia.repository.UsuarioRepository;
import ProjetoSocialMedia.SocialMedia.configuration.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    @Autowired
    private UsuarioRepository usuarioRepository;


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login) throws AuthenticationException {
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(login.login(), login.password());

        var authenticate = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var usuario = (Usuario) authenticate.getPrincipal();

        String token = tokenService.gerarToken(usuario);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid RegisterDTO registerDTO) throws AuthenticationException {

        if (this.usuarioRepository.findByLogin(registerDTO.login()) != null)
            return ResponseEntity.badRequest().body("Login já em uso. Escolha outro login.");

        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        var usuario = new Usuario(registerDTO.login(), encryptedPassword, registerDTO.role());

        this.usuarioRepository.save(usuario);

        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }
}