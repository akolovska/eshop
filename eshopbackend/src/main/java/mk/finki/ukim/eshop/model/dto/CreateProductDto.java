package mk.finki.ukim.eshop.model.dto;

import jakarta.validation.constraints.Positive;
import mk.finki.ukim.eshop.model.domain.Product;
import mk.finki.ukim.eshop.model.domain.Category;
import java.math.BigDecimal;

public record CreateProductDto(String name,
                               String description,
                               @Positive
                               BigDecimal price,
                               Integer quantity,
                               Long categoryId
) {
    public Product toProduct(Category category) {
        return new Product(name, description, price, quantity, category);
    }
}
