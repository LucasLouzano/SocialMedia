package ProjetoSocialMedia.SocialMedia;

import ProjetoSocialMedia.SocialMedia.model.Usuario;
import ProjetoSocialMedia.SocialMedia.repository.UsuarioRepository;
import ProjetoSocialMedia.SocialMedia.service.impl.UsuarioServiceImpl;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @BeforeClass
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("ProjetoSocialMedia.SocialMedia.templete");
    }


    @Test
    public void deveBuscarPorId() {
        Usuario usuario =Fixture.from(Usuario.class).gimme("valid");

        Mockito.when(usuarioRepository.findById(ArgumentMatchers.anyLong()))
                .thenReturn(Optional.of(usuario));
        Optional<Usuario> usuarioOptional = usuarioService.getBuscaUsuarioPorId(1L);
        Assert.assertTrue(usuarioOptional.isPresent());
    }
    @Test
    public void deveSalvarIndentificacao(){
        Usuario usuarios = Fixture.from(Usuario.class).gimme("valid");

        Mockito.when(usuarioRepository.findAll())
                .thenReturn(List.of(usuarios));
        List<Usuario> usuarios1 = usuarioService.findAll();
        Assert.assertNotNull(usuarios1);


    }

}
