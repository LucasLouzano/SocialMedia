package ProjetoSocialMedia.SocialMedia.dto;

import ProjetoSocialMedia.SocialMedia.model.product.Product;

public record ProductResponseDTO(Long id, String name, Integer price) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice());

    }
}

