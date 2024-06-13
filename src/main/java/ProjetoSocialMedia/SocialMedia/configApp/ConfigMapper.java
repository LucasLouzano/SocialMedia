package ProjetoSocialMedia.SocialMedia.configApp;

import ProjetoSocialMedia.SocialMedia.mapper.PostsMapper;
import ProjetoSocialMedia.SocialMedia.mapper.ValorPagamentoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConfigMapper {
    @Bean
    public PostsMapper postsMapper() {
        return Mappers.getMapper(PostsMapper.class);
    }

    @Bean
    public ValorPagamentoMapper valorPagamentoMapper() {
        return Mappers.getMapper(ValorPagamentoMapper.class);
    }
}

