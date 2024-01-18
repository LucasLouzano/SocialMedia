package ProjetoSocialMedia.SocialMedia.configuration;
import ProjetoSocialMedia.SocialMedia.model.users.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario) {
        return JWT.create()
                .withIssuer("Posts")
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(30)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("secreta"));
    }


    public String getSubject(String token) {
        try {
            return JWT.require(Algorithm.HMAC256("secreta"))
                    .withIssuer("Posts")
                    .build().verify(token).getSubject();

        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
