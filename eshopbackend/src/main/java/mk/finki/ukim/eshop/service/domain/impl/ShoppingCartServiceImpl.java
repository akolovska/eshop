package mk.finki.ukim.eshop.service.domain.impl;

import jakarta.transaction.Transactional;
import mk.finki.ukim.eshop.events.CartCheckedOutEvent;
import mk.finki.ukim.eshop.model.domain.CartItem;
import mk.finki.ukim.eshop.model.domain.Product;
import mk.finki.ukim.eshop.model.domain.ShoppingCart;
import mk.finki.ukim.eshop.model.exception.InsufficientStockException;
import mk.finki.ukim.eshop.model.exception.ProductNotFoundException;
import mk.finki.ukim.eshop.model.exception.ShoppingCartNotFoundException;
import mk.finki.ukim.eshop.repository.ProductRepository;
import mk.finki.ukim.eshop.repository.ShoppingCartRepository;
import mk.finki.ukim.eshop.service.domain.ShoppingCartService;
import org.springframework.context.ApplicationEventPublisher;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public ShoppingCartServiceImpl(
            ShoppingCartRepository shoppingCartRepository,
            ProductRepository productRepository,
            ApplicationEventPublisher applicationEventPublisher
    ) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    @Transactional
    public void checkout(Long cartId) {
        ShoppingCart shoppingCart = shoppingCartRepository.findById(cartId)
                .orElseThrow(() -> new ShoppingCartNotFoundException(cartId));

        for (CartItem item : shoppingCart.getCartItems()) {
            Product product = productRepository.findWithLockById(item.getProduct().getId())
                    .orElseThrow(() -> new ProductNotFoundException(item.getProduct().getId()));

            if (product.getQuantity() < item.getQuantity()) {
                throw new InsufficientStockException(product.getName());
            }

            product.setQuantity(product.getQuantity() - item.getQuantity());
            productRepository.save(product);
        }

        applicationEventPublisher.publishEvent(
                new CartCheckedOutEvent(shoppingCart, shoppingCart.getUser().getEmail())
        );
    }

}
