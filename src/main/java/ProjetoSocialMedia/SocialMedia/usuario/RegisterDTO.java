package ProjetoSocialMedia.SocialMedia.usuario;

import ProjetoSocialMedia.SocialMedia.role.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}