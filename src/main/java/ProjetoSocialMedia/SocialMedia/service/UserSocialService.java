package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.model.UserSocial;

import java.util.List;

public interface UserSocialService {
    void save(UserSocial userSocial);

    List<UserSocial> findAll();

    void deleteById(Long id);
}
