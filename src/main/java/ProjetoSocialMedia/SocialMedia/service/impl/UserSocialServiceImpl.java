package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.model.Post;
import ProjetoSocialMedia.SocialMedia.repository.UserSocialRepository;
import ProjetoSocialMedia.SocialMedia.service.UserSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSocialServiceImpl implements UserSocialService {
    @Autowired
    private UserSocialRepository userSocialRepository;

    @Override
    public void save(Post userSocial) {
        if (userSocial != null) {
            userSocialRepository.save(userSocial);
        }
    }
    @Override
    public List<Post> findAll() {
        return userSocialRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        userSocialRepository.deleteById(id);
    }
}
