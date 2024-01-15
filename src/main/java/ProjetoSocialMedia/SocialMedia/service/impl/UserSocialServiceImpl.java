package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.model.UserSocial;
import ProjetoSocialMedia.SocialMedia.repository.UserSocialRepository;
import ProjetoSocialMedia.SocialMedia.service.UserSocialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSocialServiceImpl implements UserSocialService {
    private UserSocialRepository userSocialRepository;

    @Override
    public void save(UserSocial userSocial) {
        userSocialRepository.save(userSocial);
    }

    @Override
    public List<UserSocial> findAll() {
        return userSocialRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userSocialRepository.deleteById(id);
    }
}
