package ProjetoSocialMedia.SocialMedia.dto;

public class PostsDTO {

    private Long id;
    private String texto;

    public PostsDTO() {
    }

    public PostsDTO(Long id, String texto) {
        this.id = id;
        this.texto = texto;
    }

//    public PostsDTO(PostsDTO postsDTO) {
//        this.id = postsDTO.getId();
//        this.texto = postsDTO.getTexto();
//    }

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
}
