//package ProjetoSocialMedia.SocialMedia;
//
//import ProjetoSocialMedia.SocialMedia.model.Usuario;
//import ProjetoSocialMedia.SocialMedia.model.product.Product;
//import ProjetoSocialMedia.SocialMedia.repository.UsuarioRepository;
//import ProjetoSocialMedia.SocialMedia.service.impl.ProductServiceImpl;
//import br.com.six2six.fixturefactory.Fixture;
//import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
//import org.junit.Assert;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.util.List;
//
//@RunWith(MockitoJUnitRunner.class)
//public class UsuarioServiceImplTest {
//
//    @Mock
//    private UsuarioRepository usuarioRepository;
//
//    @InjectMocks
//    private ProductServiceImpl productService;
//
//    @BeforeClass
//    public static void setUp() {
//        FixtureFactoryLoader.loadTemplates("ProjetoSocialMedia.SocialMedia.templete");
//    }
//
//
////    @Test
////    public void deveBuscarPorId() {
////        Product product = Fixture.from(Usuario.class).gimme("valid");
////
////        Mockito.when(usuarioRepository.findById(ArgumentMatchers.anyLong()))
////                .thenReturn(Optional.of(product));
////        Optional<Usuario> usuarioOptional = productService.getBuscaProductPorId(1l);
////        Assert.assertTrue(usuarioOptional.isPresent());
////    }
//    @Test
//    public void deveSalvarUsuario(){
//        Product products = Fixture.from(Usuario.class).gimme("valid");
//
//        Mockito.when(productService.findAll())
//                .thenReturn(List.of(products));
//        List<Product> usuarios1 = productService.findAll();
//        Assert.assertNotNull(usuarios1);
//
//
//    }
//
//}
