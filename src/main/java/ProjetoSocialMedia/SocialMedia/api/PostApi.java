package ProjetoSocialMedia.SocialMedia.api;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class PostApi {
    @Autowired
    private OkHttpClient httpClient;

    public PostsDTO save(Posts posts) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(posts));
        Request request = new Request.Builder()
                .url("http://localhost:8082/posts")
                .addHeader("Accept", "application/json")
                .post(requestBody)
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }

            String jsonResponse = response.body().string();
            return new Gson().fromJson(jsonResponse, PostsDTO.class);
        } catch (IOException e) {
            throw new RuntimeException("Error during HTTP request", e);
        }
    }


    public PostsDTO findById(Long id) {
        Request request = new Request.Builder()
                .url("http://localhost:8082/posts/" + id)
                .addHeader("Accept", "application/json")
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                if (response.code() == 404) {
                    return null;
                } else {
                    throw new IOException("Unexpected response code: " + response);
                }
            }

            String jsonResponse = response.body().string();
            PostsDTO postDTO = new Gson().fromJson(jsonResponse, PostsDTO.class);

            return postDTO;
        } catch (IOException e) {
            throw new RuntimeException("Error during HTTP request", e);
        }
    }


    public List<PostsDTO> findAll() {
        Request request = new Request.Builder()
                .url("http://localhost:8082/posts")
                .addHeader("Accept", "application/json")
                .build();

        try {
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }

            String jsonDeResposta = response.body().string();
            System.out.println(jsonDeResposta);

            Type listaDePostsType = new TypeToken<List<PostsDTO>>() {
            }.getType();
            Gson gson = new Gson();
            List<PostsDTO> postsDTOList = gson.fromJson(jsonDeResposta, listaDePostsType);

            postsDTOList.forEach(post -> System.out.println(post.getTexto()));

            return postsDTOList;
        } catch (IOException e) {
            throw new RuntimeException("Error during HTTP request", e);
        }
    }


    public PostsDTO update(Posts posts) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), new Gson().toJson(posts));
        Request request = new Request.Builder()
                .url("http://localhost:8082/posts")
                .post(requestBody)
                .build();
        try {
            Response response = httpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected response code: " + response);
            }

            String jsonResponse = response.body().string();
            PostsDTO postsDTO = new Gson().fromJson(jsonResponse, PostsDTO.class);

            return postsDTO;
        } catch (IOException e) {
            throw new RuntimeException("Error during HTTP request", e);
        }
    }
}
