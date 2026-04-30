package mk.finki.ukim.eshop.model.dto;

import mk.finki.ukim.eshop.model.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public record DisplayProductDto(Long id,
                                String name,
                                String description,
                                BigDecimal price,
                                Integer quantity,
                                Long categoryId
) {
    public static DisplayProductDto from(Product product) {
        return new DisplayProductDto(product.getId(), product.getName(), product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory().getId()
        );
    }
    public static List<DisplayProductDto> from(List<Product> products) {
        return products.stream()
                .map(DisplayProductDto::from)
                .toList();
    }
}
