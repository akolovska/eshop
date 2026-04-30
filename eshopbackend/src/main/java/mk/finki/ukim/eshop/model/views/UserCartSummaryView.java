package mk.finki.ukim.eshop.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.math.BigDecimal;

@Entity
@Getter
@Immutable
@Table(name = "user_cart_summary_view")
public class UserCartSummaryView {
    @Id
    private Long id;

    private String fullName;

    private String email;

    private Integer totalItems;

    private Integer totalQuantity;

    private BigDecimal totalPrice;
}
