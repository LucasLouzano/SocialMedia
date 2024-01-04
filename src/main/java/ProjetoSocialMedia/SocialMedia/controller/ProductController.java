package ProjetoSocialMedia.SocialMedia.controller;


import ProjetoSocialMedia.SocialMedia.model.product.Product;
import ProjetoSocialMedia.SocialMedia.dto.ProductRequestDTO;
import ProjetoSocialMedia.SocialMedia.dto.ProductResponseDTO;
import ProjetoSocialMedia.SocialMedia.service.impl.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

//    @GetMapping("/{id}")
//    public ResponseEntity find(@PathVariable Long id) {
//        Optional<ProductRequestDTO> product = this.productService.getBuscaProductPorId(id);
//        return product
//                .map(use -> ResponseEntity.ok().body(use)) // Retorna o usuário se presente
//                .orElseGet(() -> ResponseEntity.notFound().build()); // Retorna 404 se ausente
//    }
    @GetMapping
    public ResponseEntity getAllUsuario() {
        List<ProductResponseDTO> listProduct = this.productService.findAll()
                .stream().map(ProductResponseDTO::new).toList();
        return ResponseEntity.ok(listProduct);
    }

    @PostMapping
    public ResponseEntity salvarUsuario(@RequestBody @Valid ProductRequestDTO body) {
        Product Produto = new Product(body);

        this.productService.save(Produto);
        return ResponseEntity.ok().build();
    }

//    @PutMapping("/users")
//    public ResponseEntity<ProductResponseDTO> update(Long id, @RequestBody ProductResponseDTO product) {
//        Product products = productService.atualizar(id, product);
//        return ResponseEntity.ok().body(products);
//    }

//    @DeleteMapping("/{id}")
//    public void deleteByid(@PathVariable("id") Long id) {
//        productService.deleteByid(id);
//    }

}
