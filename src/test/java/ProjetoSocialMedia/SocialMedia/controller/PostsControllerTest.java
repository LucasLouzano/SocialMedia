package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.service.impl.PostsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
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
        var posts = new Posts();
        posts.setId(1L);
        posts.setTexto("Texto");
        posts.setAuthor("Lucas");
        posts.setCreateDateTime(LocalDateTime.now());

        PostsDTO postDTO = new PostsDTO( "Texto",LocalDateTime.now());
        when(service.findAll()).thenReturn(List.of(postDTO));

        ResponseEntity<List<PostsDTO>> resposta = controller.GetPosts();
        assertEquals(HttpStatus.OK,resposta.getStatusCode());
        assertNotNull((resposta.getBody()));
        verify(service, times(1)).findAll();
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
    void testSavePosts() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setTexto("Texto");
        posts.setAuthor("Lucas");
        posts.setCreateDateTime(LocalDateTime.now());
        // Mock do serviço para retornar um DTO esperado
        PostsDTO postsDTO = new PostsDTO( "Texto",LocalDateTime.now());
        when(service.save(any())).thenReturn(postsDTO);

        // Chamada ao método do controlador
        ResponseEntity<PostsDTO> respon = controller.savePosts(posts);

        // Verificações
        assertEquals(HttpStatus.OK, respon.getStatusCode());
        assertEquals(postsDTO, respon.getBody());
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
}