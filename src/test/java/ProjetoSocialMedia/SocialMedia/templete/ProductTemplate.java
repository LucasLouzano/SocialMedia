package ProjetoSocialMedia.SocialMedia.templete;

import ProjetoSocialMedia.SocialMedia.model.product.Product;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class ProductTemplate implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(Product.class).addTemplate("valid", new Rule() {
            {
                add("id", 1L);
                add("login", "lucaslouzano");
            }
        });

    }
}
