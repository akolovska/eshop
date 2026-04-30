package mk.finki.ukim.eshop.service.domain;

import mk.finki.ukim.eshop.model.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Optional<Category> findById(Long id);

    List<Category> findAll();

    Category create(Category category);

    Optional<Category> update(Long id, Category category);

    Optional<Category> deleteById(Long id);
}
