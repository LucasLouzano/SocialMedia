package ProjetoSocialMedia.SocialMedia.configApp;

import com.squareup.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostApiConfiguration {
    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }
}
