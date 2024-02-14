package ProjetoSocialMedia.SocialMedia.config;

import ProjetoSocialMedia.SocialMedia.mapper.PostsMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
    @Bean
    public PostsMapper postsMapper() {
        return Mappers.getMapper(PostsMapper.class);
    }
}

