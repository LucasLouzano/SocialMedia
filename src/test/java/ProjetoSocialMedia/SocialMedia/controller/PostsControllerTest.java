//package ProjetoSocialMedia.SocialMedia.controller;
//
//import ProjetoSocialMedia.SocialMedia.dto.PostsDTO;
//import ProjetoSocialMedia.SocialMedia.mapper.PostsMapper;
//import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
//import ProjetoSocialMedia.SocialMedia.service.impl.PostsServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Objects;
//
//import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.times;
//
//
//@ExtendWith(MockitoExtension.class)
//class PostsControllerTest {
//    @InjectMocks
//    private PostsController controller;
//    @Mock
//    private PostsServiceImpl service;
//
//    @Autowired
//    private PostsMapper mapper;
//
//    @Test
//    void quandoBuscarTodosRetorneUmaLista() {
//        var postsDTO = new PostsDTO();
//        postsDTO.setId(1L);
//        postsDTO.setTexto("Texto");
//
//        when(service.findAll()).thenReturn(List.of(postsDTO());
//        when(mapper.postsToPostsDTO(any())).thenReturn(postsDTO);
//
//        ResponseEntity<List<PostsDTO>> resposta = controller.GetPosts();
//        assertNotNull(resposta);
//        assertNotNull((resposta.getBody()));
//        Assertions.assertEquals(service,  resposta.getClass());
//        verify(service,times(1)).findAll();
//    }
//
//
//    @Test
//    void getPostById() {
//        var posts = new Posts();
//        posts.setId(1L);
//        posts.setAuthor("Lucas");
//        posts.setTexto("Texto");
//        posts.setCreateDateTime(LocalDateTime.now());
//
//        when(service.findById(anyLong())).thenReturn(posts);
//        ResponseEntity<Posts> response = controller.getPostById(1L);
//        assertNotNull(response);
//        assertNotNull(response.getBody());
//        assertEquals(ResponseEntity.class, response.getClass());
//    }
//
//    @Test
//    void quandoSalvarRetorneCreate() {
//        var postsDTO = new PostsDTO();
//        postsDTO.setId(1L);
//        postsDTO.setTexto("Texto");
//
//        when(service.save(any())).thenReturn((PostsDTO));
//        ResponseEntity<PostsDTO> respon = controller.savePosts(postsDTO);
//        assertNotNull(ResponseEntity.class,(respon.getBody()));
//
//    }
//
//    @Test
//    void atualizar() {
//        var posts = new Posts();
//        posts.setId(1L);
//        posts.setAuthor("Lucas");
//        posts.setTexto("Texto");
//        posts.setCreateDateTime(LocalDateTime.now());
//        when(service.update(posts)).thenReturn(posts);
//        ResponseEntity<Posts> response = controller.atualizar(1L, posts);
//        assertNotNull(response);
//        assertNotNull(response.getBody());
//        assertEquals(ResponseEntity.class, response.getClass());
//
//    }
//}