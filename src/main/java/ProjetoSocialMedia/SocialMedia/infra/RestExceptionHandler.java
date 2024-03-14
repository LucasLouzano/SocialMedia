package ProjetoSocialMedia.SocialMedia.infra;

import ProjetoSocialMedia.SocialMedia.exception.PostsNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PostsNotFound.class)
    private ResponseEntity<String> postsNotFoundHandler(PostsNotFound exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Posts not found.");

    }
}
