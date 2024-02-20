package ProjetoSocialMedia.SocialMedia.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("projetoSocialMedia.SocialMedia.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());

    }

    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring boot Rest Api")
                .description("Demo project for Spring Boot Social Media.")
                .version("1.0.0")
                .contact(new Contact("Lucas Louzano","https://github.com/LucasLouzano/SocialMedia", "lucaslouzano@55gmail.com"))
                .build();
    }
}