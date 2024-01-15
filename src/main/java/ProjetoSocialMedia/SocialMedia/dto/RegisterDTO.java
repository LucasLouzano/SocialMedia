package ProjetoSocialMedia.SocialMedia.dto;

import ProjetoSocialMedia.SocialMedia.role.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
