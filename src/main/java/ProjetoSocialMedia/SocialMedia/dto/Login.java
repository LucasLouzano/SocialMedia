package ProjetoSocialMedia.SocialMedia.dto;

import ProjetoSocialMedia.SocialMedia.role.UserRole;

public record Login(String login, String password, UserRole admin) {
}
