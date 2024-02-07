package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.service.impl.PostsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.time.LocalDateTime;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


@ExtendWith(MockitoExtension.class)
class PostsControllerTest {
    @InjectMocks
    private PostsController controller;
    @Mock
    private PostsServiceImpl service;

    @Test
    void quandoBuscarTodosRetorneUmaLista() {
        var post = new Posts();
        post.setId(1L);
        post.setAuthor("Lucas");
        post.setTexto("Texto");
        post.setCreateDateTime(LocalDateTime.now());

        when(service.findAll()).thenReturn(List.of(post));
        ResponseEntity <List<Posts>> resposta = controller.GetPosts();
        assertNotNull(resposta);
        assertNotNull(resposta.getBody());
        assertEquals(ResponseEntity.class, resposta.getClass());
    }

    @Test
    void getPostById() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("Lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());

        when(service.findById(anyLong())).thenReturn(posts);
        ResponseEntity<Posts> response = controller.getPostById(1L);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());
    }

    @Test
    void quandoSalvarRetorneCreate() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("Lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());

        when(service.save(any())).thenReturn(posts);
        ResponseEntity<String> respon = controller.savePosts(posts);
        assertNotNull(ResponseEntity.class, respon.getBody());

    }

    @Test
    void atualizar() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("Lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());
        when(service.update(posts)).thenReturn(posts);
        ResponseEntity<Posts> response = controller.atualizar(1L, posts);
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());

    }

    @Test
    void deletePost() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("Lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());
        doNothing().when(service).delete(anyLong());
        ResponseEntity<Void> response = controller.delete(1L);
        assertNotNull(response);
        assertEquals(ResponseEntity.class, response.getClass());
        verify(service, times(1)).delete(anyLong());
    }
}