package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
import ProjetoSocialMedia.SocialMedia.mapper.PostsMapper;
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

    @Mock
    private PostsMapper mapper;

    @InjectMocks
    private PostsServiceImpl service;

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
        assertEquals(1L, response.getId());
        assertEquals("Texto", response.getTexto());
        assertEquals("author", response.getAuthor());

    }
    @Test
    void findAll() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setTexto("Texto");
        posts.setAuthor("Lucas");
        posts.setCreateDateTime(LocalDateTime.now());
        // Configurando o mock do repository para retornar uma lista de Posts
        when(repository.findAll()).thenReturn(List.of(posts));
        // Chamando o método do serviço que queremos testar
        List<PostsDTO> postsDTOList = service.findAll();
        // Verificações
        assertNotNull(postsDTOList);
        assertEquals(1, postsDTOList.size());

        PostsDTO postsDTO = postsDTOList.get(0);
        assertEquals(PostsDTO.class, postsDTO.getClass());
//        assertEquals(1L, postsDTO.getId());
        assertEquals("Texto", postsDTO.getTexto());
    }

    @Test
    void salvarComSucesso() {
        var posts = new Posts();
        posts.setId(1L);
        posts.setAuthor("Lucas");
        posts.setTexto("Texto");
        posts.setCreateDateTime(LocalDateTime.now());
        when(repository.save(any())).thenReturn(posts);

        // Configuração do mock do mapper para retornar o objeto PostsDTO
        var postsDTO = new PostsDTO();
        postsDTO.setTexto("Texto");
        when(mapper.postsToPostsDTO(eq(posts))).thenReturn(postsDTO);

        PostsDTO resposta = service.save(posts);

        // Verifica se a resposta não é nula
        assertNotNull(resposta);

        // Verifica se a classe da resposta é PostsDTO
        assertEquals(PostsDTO.class, resposta.getClass());

       // Verifica se os atributos da resposta são iguais aos atributos do objeto PostsDTO esperado
        assertEquals(postsDTO.getTexto(), resposta.getTexto());

        // Verifica se o método save do repository foi chamado com o objeto Posts correto
        verify(repository).save(eq(posts));
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