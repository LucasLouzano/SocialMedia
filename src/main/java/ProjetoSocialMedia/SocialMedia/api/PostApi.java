package ProjetoSocialMedia.SocialMedia.api;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class PostApi {

    public List<PostsDTO> findAll() {
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:8082/posts").addHeader("Accept", "application/json").build();

        try {
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }

            String jsonDeResposta = response.body().string();
            System.out.println(jsonDeResposta);

            Type listaDePostsType = new TypeToken<List<PostsDTO>>() {}.getType();
            Gson gson = new Gson();
            List<PostsDTO> postsDTOList = gson.fromJson(jsonDeResposta, listaDePostsType);

//            postsDTOList.forEach(post -> System.out.println(post.getTitle()));

            return postsDTOList;
        } catch (IOException e) {
            throw new RuntimeException("Error during HTTP request", e);
        }
    }
}
