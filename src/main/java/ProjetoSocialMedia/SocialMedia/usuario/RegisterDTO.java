package ProjetoSocialMedia.SocialMedia.usuariodto;

import ProjetoSocialMedia.SocialMedia.role.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}