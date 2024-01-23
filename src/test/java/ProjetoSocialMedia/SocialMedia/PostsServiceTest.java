//package ProjetoSocialMedia.SocialMedia;
//
//
//import ProjetoSocialMedia.SocialMedia.model.posts.Posts;
//import ProjetoSocialMedia.SocialMedia.model.users.Usuario;
//import ProjetoSocialMedia.SocialMedia.repository.PostsRepository;
//import ProjetoSocialMedia.SocialMedia.service.impl.PostsServiceImpl;
//import br.com.six2six.fixturefactory.Fixture;
//import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class PostsServiceTest {
//
//    @Mock
//    private PostsRepository postsRepository;
//
//    @InjectMocks
//    private PostsServiceImpl postsService;
//
//    @BeforeClass
//    public static void setUp() {
//        FixtureFactoryLoader.loadTemplates("ProjetoSocialMedia.SocialMedia.templete");
//
//    }

//    @Test
//    public void deveBuscarTodosOsPosts() {
//        var posts = new Posts();
//        posts.setId(1L);
//        posts.setTexto("Texto");
//        posts.setAuthor("author");
//        posts.setCreateDateTime(LocalDateTime.now());
//
//        when(postsService.findAllByOrderByCreateDateTimeDesc()).thenReturn(List.of(posts));
//        List<Posts> posts1 = postsService.findAllByOrderByCreateDateTimeDesc();
//        Assert.assertNotNull(posts1);
//    }

//    @Test
//    public void deveBuscarPorId() {
//        var posts = new Posts();
//        posts.setId(1L);
//        posts.setTexto("Texto");
//        posts.setAuthor("author");
//        posts.setCreateDateTime(LocalDateTime.now());
//
//        when(postsRepository.save(any())).thenReturn(posts);
////        when(postsRepository.findById(any())).thenReturn(Optional.of(posts));
//
//        Posts postagem = postsService.findById(1l);
//
//        Assert.assertNotNull(postagem);
//        Assert.assertEquals("Texto", postagem.getTexto());
//        Assert.assertEquals("author", postagem.getAuthor());
//
//    }



//    @Test
//    public void salvarUmPosts() {
//        var posts = new Posts();
//        posts.setId(1L);
//        posts.setTexto("Texto");
//        posts.setAuthor("author");
//        posts.setCreateDateTime(LocalDateTime.now());
//        when(postsRepository.save(any(Posts.class))).thenReturn(new Posts());
//
//        Posts posts1 = postsService.save(posts);
//        Assert.assertNotNull(posts1);
//
//    }

//    @Test
//    public void atualizarTodosOsPosts() {
//
//    }
//
//    @Test
//    public void detetarTodosOsPosts() {
//
//    }
//}


//        Posts posts = Fixture.from(Posts.class).gimme("valid");
//        Posts posts = Fixture.from(Posts.class).gimme("valid");