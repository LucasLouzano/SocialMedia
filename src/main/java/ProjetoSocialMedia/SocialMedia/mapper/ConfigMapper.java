package ProjetoSocialMedia.SocialMedia.mapper;
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

