package mk.finki.ukim.eshop.repository;

import jakarta.transaction.Transactional;
import mk.finki.ukim.eshop.config.JpaConfig;
import mk.finki.ukim.eshop.model.domain.*;
import org.springframework.context.annotation.Import;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import java.math.BigDecimal;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest(properties = "spring.flyway.enabled=false")
@Import(JpaConfig.class)
@Transactional
public class ShoppingCartRepositoryTest {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CartItemRepository cartItemRepository;

    @Autowired
    TestEntityManager testEntityManager;

    private User user;

    @BeforeEach
    void setUp() {
        Category category = categoryRepository.save(new Category("Electronics", "Electronic devices"));

        Product laptop = productRepository.save(new Product("Laptop", "A laptop", new BigDecimal("999.99"), 50, category));
        Product mouse = productRepository.save(new Product("Mouse", "A mouse", new BigDecimal("29.99"), 200, category));
        Product desk = productRepository.save(new Product("Desk", "A desk", new BigDecimal("349.99"), 15, category));

        user = userRepository.save(new User("John", "Doe", "john.doe@example.com"));

        ShoppingCart cart = shoppingCartRepository.save(new ShoppingCart(user));

        cartItemRepository.save(new CartItem(cart, laptop, 2));
        cartItemRepository.save(new CartItem(cart, mouse, 1));
        cartItemRepository.save(new CartItem(cart, desk, 4));

        testEntityManager.flush();
        testEntityManager.clear();
    }

    @Test
    void testFindByUserId() {
        ShoppingCart shoppingCart = shoppingCartRepository.findByUserId(user.getId()).orElseThrow();

        assertThat(shoppingCart).isNotNull();
        assertThat(shoppingCart.getCartItems()).hasSize(3);

        List<String> productNames = shoppingCart.getCartItems().stream()
                .map(item -> item.getProduct().getName())
                .toList();

        assertThat(productNames).containsExactlyInAnyOrder("Laptop", "Mouse", "Desk");
    }

    @Test
    void testFindWithCartItemsByUserId() {
        ShoppingCart shoppingCart = shoppingCartRepository.findWithCartItemsByUserId(user.getId()).orElseThrow();

        assertThat(shoppingCart).isNotNull();
        assertThat(shoppingCart.getCartItems()).hasSize(3);

        List<String> productNames = shoppingCart.getCartItems().stream()
                .map(item -> item.getProduct().getName())
                .toList();

        assertThat(productNames).containsExactlyInAnyOrder("Laptop", "Mouse", "Desk");
    }
}
