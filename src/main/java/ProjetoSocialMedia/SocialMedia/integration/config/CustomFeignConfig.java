//package ProjetoSocialMedia.SocialMedia.integration.config;
//
//import com.squareup.okhttp.OkHttpClient;
//import feign.Contract;
//import feign.auth.BasicAuthRequestInterceptor;
//import org.springframework.context.annotation.Bean;
//
//public class CustomFeignConfig {
//
//    @Bean
//    public Contract feignContract() {
//        return new feign.Contract.Default();
//    }
//
//    @Bean
//    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
//        return new BasicAuthRequestInterceptor("user", "password");
//    }
//
//    @Bean
//    public OkHttpClient client() {
//        return new OkHttpClient();
//    }
//
//}
