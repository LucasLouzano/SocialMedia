package ProjetoSocialMedia.SocialMedia.exception;

public class PostsNotFound extends RuntimeException {
    public PostsNotFound() {
        super("Posts salvo com sucesso!");
    }

    public PostsNotFound(String message) {
        super(message);
    }
}