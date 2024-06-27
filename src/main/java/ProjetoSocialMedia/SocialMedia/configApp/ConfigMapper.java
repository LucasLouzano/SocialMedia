package ProjetoSocialMedia.SocialMedia.configApp;

import ProjetoSocialMedia.SocialMedia.mapper.PostsMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigMapper {
    @Bean
    public PostsMapper postsMapper() {
        return Mappers.getMapper(PostsMapper.class);
    }
}

