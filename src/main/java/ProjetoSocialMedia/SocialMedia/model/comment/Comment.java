package ProjetoSocialMedia.SocialMedia.model.comment;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String author;
    private LocalDate createDateTime;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts posts;

    public Comment(Comment comment) {
        this.id = comment.getId();
        this.message = comment.message;
        this.author = comment.author;
        this.createDateTime = comment.getCreateDateTime();
        this.posts = comment.getPosts();
    }

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

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }
}
