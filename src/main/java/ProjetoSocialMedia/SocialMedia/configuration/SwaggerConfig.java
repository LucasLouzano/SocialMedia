package ProjetoSocialMedia.SocialMedia.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto Social Media")
                        .description("Um projeto de mídia social para interações online.")
                        .version("1.0.0")
                        .license(new License().name("Apache 2.0").url("https://github.com/LucasLouzano/SocialMedia")));
    }
}