package ProjetoSocialMedia.SocialMedia.model.comment;


import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private String author;
    private LocalDateTime createDateTime;
    @ManyToOne
    @JoinColumn(name = "post_id") // juntar coluna join column
    private Posts posts;


    public Comments() {
    }

    public Comments(Long id, String message, String author, LocalDateTime createDateTime, Posts posts) {
        this.id = id;
        this.message = message;
        this.author = author;
        this.createDateTime = createDateTime;
        this.posts = posts;
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

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", author='" + author + '\'' +
                ", createDateTime=" + createDateTime +
                ", posts=" + posts +
                '}';
    }
}