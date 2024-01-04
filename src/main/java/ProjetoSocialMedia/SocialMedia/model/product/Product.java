package ProjetoSocialMedia.SocialMedia.model.product;

import ProjetoSocialMedia.SocialMedia.dto.ProductRequestDTO;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Table(name = "product")
@Entity(name = "product")
@EqualsAndHashCode(of = "id")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;

    private String name;

    private Integer price;

    public Product(ProductRequestDTO data) {
        this.price = data.price();
        this.name = data.name();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;

    }
}
