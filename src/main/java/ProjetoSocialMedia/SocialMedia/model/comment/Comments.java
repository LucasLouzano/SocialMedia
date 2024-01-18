package ProjetoSocialMedia.SocialMedia.model.comment;


import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String author;
    private LocalDate createDateTime;
    @ManyToOne
    @JoinColumn(name = "post_id") // juntar coluna join column
    private Posts posts;

    public Comments(Long id, String message, String author, LocalDate createDateTime, Posts posts) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.createDateTime = createDateTime;
        this.posts = posts;
    }

    public Comments() {
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
