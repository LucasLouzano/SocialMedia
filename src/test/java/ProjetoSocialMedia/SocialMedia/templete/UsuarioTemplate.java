package ProjetoSocialMedia.SocialMedia.templete;

import ProjetoSocialMedia.SocialMedia.model.Usuario;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class UsuarioTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Usuario.class).addTemplate("valid", new Rule() {
            {
                add("id", 1L);
                add("login", "lucaslouzano");
            }
        });

    }
}
