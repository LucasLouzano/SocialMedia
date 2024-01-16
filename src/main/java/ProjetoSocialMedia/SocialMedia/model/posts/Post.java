package ProjetoSocialMedia.SocialMedia.model.posts;

import ProjetoSocialMedia.SocialMedia.model.comment.Comment;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private String author;
    private LocalDate createDateTime;
    @OneToMany
    private List <Comment> comment;

    public Post(Long id, String texto, String author, LocalDate createDateTime, List<Comment> comment) {
        this.id = id;
        this.texto = texto;
        this.author = author;
        this.createDateTime = createDateTime;
        this.comment = comment;
    }

    public Post(Post post) {
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

    public LocalDate getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDate createDateTime) {
        this.createDateTime = createDateTime;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
