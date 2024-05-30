package ProjetoSocialMedia.SocialMedia.model;


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

    public Comments(Comments comments) {
        this.id = comments.getId();
        this.message = comments.getMessage();
        this.author = comments.getAuthor();
        this.createDateTime = comments.getCreateDateTime();
        this.posts = comments.getPosts();
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
}
