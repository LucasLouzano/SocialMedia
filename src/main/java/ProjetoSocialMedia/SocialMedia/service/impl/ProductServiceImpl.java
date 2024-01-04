package ProjetoSocialMedia.SocialMedia.service.impl;

import ProjetoSocialMedia.SocialMedia.model.Usuario;
import ProjetoSocialMedia.SocialMedia.model.product.Product;
import ProjetoSocialMedia.SocialMedia.repository.ProductRepository;
import ProjetoSocialMedia.SocialMedia.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product Product) {
        if (Product != null) {
            this.productRepository.save(Product);
        }
    }
}

//    @Override
//    public Product atualizar(Long id, Product product) {
//        Optional<Product> products = productRepository.findById(id);
//        if (products.isPresent()) {
//            products.get().setLogin(product.getLogin());
//            products.get().setPassword(product.getPassword());
//            return products.get();
//        }
//        return null;
//    }

//    @Override
//    public void deleteByid(Long id) {
//        productRepository.deleteById(id);
//    }

//    @Override
//    public Optional<Usuario> getBuscaProductPorId(Long id) {
//        return productRepository.findById(id);
//
//    }
