package ProjetoSocialMedia.SocialMedia.dto;

import ProjetoSocialMedia.SocialMedia.model.UsuarioRole;

public record ResgisterDTO(String login, String password, UsuarioRole role) {
}
