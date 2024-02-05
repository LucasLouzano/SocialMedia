package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.repository.PostsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PostsServiceImplTest {
    private static final int INDICE = 0;

    @Mock
    private PostsRepository repository;
    @InjectMocks
    private PostsServiceImpl service;


    @Test
    void findAll() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setTexto("Texto");
        posts.setAuthor("author");
        posts.setCreateDateTime(LocalDateTime.now());

        when(repository.findAll()).thenReturn(List.of(posts));
        List<Posts> posts1 = service.findAll();
        assertNotNull(posts1);
        assertEquals(1,posts1.size());

        assertEquals(Posts.class, posts1.get(INDICE).getClass());
        assertEquals(1L,posts1.get(INDICE).getId());
        assertEquals("Texto",posts1.get(INDICE).getTexto());
        assertEquals("author",posts1.get(INDICE).getAuthor());
    }

    @Test
    void findById() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setTexto("Texto");
        posts.setAuthor("author");
        posts.setCreateDateTime(LocalDateTime.now());

        when(repository.findById(Mockito.anyLong())).thenReturn(Optional.of(posts));

        Posts response = service.findById(1L);

        assertNotNull(response);
        assertEquals(Posts.class, response.getClass());
        assertEquals(1L,response.getId());
        assertEquals("Texto",response.getTexto());
        assertEquals("author",response.getAuthor());

    }

    @Test
    void salvarComSucesso() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("Lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());

        when(repository.save(any())).thenReturn(posts);

        Posts post = service.save(posts);

        assertNotNull(post);
        assertEquals(Posts.class, post.getClass());
        assertEquals(1L, post.getId());
        assertEquals("Lucas", post.getAuthor());
        assertEquals("Texto", post.getTexto());
        assertNotNull(post.getCreateDateTime());
    }

    @Test
    void quandoAtualizarRetornaSucesso() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("Lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());

        when(repository.save(any())).thenReturn(posts);

        Posts post = service.update(posts);

        assertNotNull(post);
        assertEquals(Posts.class, post.getClass());
        assertEquals(1L, post.getId());
        assertEquals("Lucas", post.getAuthor());
        assertEquals("Texto", post.getTexto());
        assertNotNull(post.getCreateDateTime());
    }

    @Test
    void deletarComSucesso() {
        when(repository.findById(anyLong())).thenReturn(Optional.of(new Posts()));
        doNothing().when(repository).deleteById(anyLong());
        service.delete(1L);
        verify(repository, times(1)).deleteById(anyLong());

    }
}