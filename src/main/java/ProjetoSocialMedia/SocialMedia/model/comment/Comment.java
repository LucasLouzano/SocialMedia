package ProjetoSocialMedia.SocialMedia.model.comment;

import ProjetoSocialMedia.SocialMedia.model.posts.Post;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String author;
    private LocalDate createDateTime;
    @ManyToOne
    private Post post;

    public Comment(Long id, String message, String author, LocalDate createDateTime, Post post) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.createDateTime = createDateTime;
        this.post = post;
    }

    public Comment() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
