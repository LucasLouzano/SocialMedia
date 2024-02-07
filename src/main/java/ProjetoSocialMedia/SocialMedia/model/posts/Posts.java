package ProjetoSocialMedia.SocialMedia.model.posts;
import ProjetoSocialMedia.SocialMedia.model.comment.Comments;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private String author;
    private LocalDateTime createDateTime;

    @OneToMany
    private List<Comments> comments ;

    public Posts() {
    }
    public Posts(Posts posts) {
        this.id = posts.getId();
        this.texto = posts.getTexto();
        this.author = posts.getAuthor();
        this.createDateTime = posts.getCreateDateTime();
        this.comments = posts.getComments();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public List<Comments> getComments() {
        return comments;
    }
    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

}
