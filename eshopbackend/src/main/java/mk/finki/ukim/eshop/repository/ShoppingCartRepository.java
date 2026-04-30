package mk.finki.ukim.eshop.repository;

import mk.finki.ukim.eshop.model.domain.ShoppingCart;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserId(Long userId);
    @EntityGraph(value = "shopping-cart-entity-graph", type = EntityGraph.EntityGraphType.FETCH)
    Optional<ShoppingCart> findWithCartItemsByUserId(Long userId);
}
