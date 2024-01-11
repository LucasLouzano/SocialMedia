package ProjetoSocialMedia.SocialMedia.controller;

import ProjetoSocialMedia.SocialMedia.model.Product;
import ProjetoSocialMedia.SocialMedia.repository.ProductRepository;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @RolesAllowed("ADMIN") // ou @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> saveProduct(@Valid @RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado com sucesso!");
    }

    @GetMapping
    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @DeleteMapping("/product/{id}")
    @RolesAllowed("ADMIN")
    public void delete(@PathVariable Long id) {
        this.productRepository.deleteById(id);
    }

}

