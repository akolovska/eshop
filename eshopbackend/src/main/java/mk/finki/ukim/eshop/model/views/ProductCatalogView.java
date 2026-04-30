package mk.finki.ukim.eshop.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Immutable
@Table(name = "product_catalog_view")
public class ProductCatalogView {
    @Id
    private Long id;

    private String productName;

    private String productDescription;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private Long categoryId;

    private String categoryName;

    private Integer timesAddedToCart;

    private Integer totalQuantityInCarts;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

