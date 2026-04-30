package mk.finki.ukim.eshop.service.domain;

import mk.finki.ukim.eshop.model.domain.Product;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(Long id);

    List<Product> findAll();

    Product create(Product product);

    Optional<Product> update(Long id, Product product);

    Optional<Product> deleteById(Long id);
    Page<Product> findAll(int page, int size, String sortBy);
}
