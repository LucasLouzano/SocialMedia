package ProjetoSocialMedia.SocialMedia.service;

import ProjetoSocialMedia.SocialMedia.model.product.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    void save(Product Product);

//    Product atualizar(Long id, Product product);

//    void deleteByid(Long id);
//
//    Optional<Product> getBuscaUsuarioPorId(Long id);
}
