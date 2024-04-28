package ProjetoSocialMedia.SocialMedia.dto;

public class PostDTORequestSave {
    private String texto;

    public PostDTORequestSave() {
    }

    public PostDTORequestSave(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
