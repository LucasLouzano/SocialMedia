package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
import ProjetoSocialMedia.SocialMedia.repository.PostsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostsServiceImplTest {
    @Mock
    private PostsRepository postsRepository;
    @InjectMocks
    PostsServiceImpl service;


    @Test
    public void deveBuscarTodosOsPosts() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setTexto("Texto");
        posts.setAuthor("author");
        posts.setCreateDateTime(LocalDateTime.now());

        when(service.findAllByOrderByCreateDateTimeDesc()).thenReturn(List.of(posts));
        List<Posts> posts1 = service.findAllByOrderByCreateDateTimeDesc();
        assertNotNull(posts1);
    }
    @Test
    public void deveBuscarPorId() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setTexto("Texto");
        posts.setAuthor("author");
        posts.setCreateDateTime(LocalDateTime.now());

        when(postsRepository.findById(any())).thenReturn(Optional.of(posts));

        Posts postagem = service.findById(1L);
        assertNotNull(postagem);
        assertEquals(1L, postagem.getId());
        assertEquals("Texto", postagem.getTexto());
        assertEquals("author", postagem.getAuthor());
        assertNotNull(postagem.getCreateDateTime());

    }
    @Test
    @DisplayName("Deve salvar agendamento com sucesso")
    void salvarComSucesso() {
        // Arrange (configuração)
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("Lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());

        when(postsRepository.save(any())).thenReturn(posts);
        // Action (ação)
        Posts post = service.save(posts);

        // Assert (verificação)
        assertNotNull(post);
        assertEquals(1L, post.getId());
        assertEquals("Lucas", post.getAuthor());
        assertEquals("Texto", post.getTexto());
        assertNotNull(post.getCreateDateTime());

        verify(postsRepository).save(any());

    }
    @Test
    public void atualizarPostExistente() {

    }

    @Test
    public void detetarTodosOsPosts() {

    }
}

