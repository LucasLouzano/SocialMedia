package ProjetoSocialMedia.SocialMedia.configApp;

import ProjetoSocialMedia.SocialMedia.mapper.PostsMapper;
import com.squareup.okhttp.OkHttpClient;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PostApiConfiguration {
    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public PostsMapper postsMapper() {
        return Mappers.getMapper(PostsMapper.class);
    }
}
