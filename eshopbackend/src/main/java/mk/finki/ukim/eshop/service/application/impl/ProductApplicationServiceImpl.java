package mk.finki.ukim.eshop.service.application.impl;

import jakarta.transaction.Transactional;
import mk.finki.ukim.eshop.model.domain.Category;
import mk.finki.ukim.eshop.model.domain.Product;
import mk.finki.ukim.eshop.model.dto.CreateProductDto;
import mk.finki.ukim.eshop.model.dto.DisplayProductDto;
import mk.finki.ukim.eshop.model.exception.CategoryNotFoundException;
import mk.finki.ukim.eshop.service.application.ProductApplicationService;
import mk.finki.ukim.eshop.service.domain.CategoryService;
import mk.finki.ukim.eshop.service.domain.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductApplicationServiceImpl implements ProductApplicationService {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductApplicationServiceImpl(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Override
    public Optional<DisplayProductDto> findById(Long id) {
        return productService.findById(id).map(DisplayProductDto::from);
    }

    @Override
    public List<DisplayProductDto> findAll() {
//        return productService.findAll().stream().map(DisplayProductDto::from).toList();
        return DisplayProductDto.from(productService.findAll());
    }

    @Override
    public DisplayProductDto create(CreateProductDto createProductDto) {
        Category category = categoryService.findById(createProductDto.categoryId()).orElseThrow(() -> new CategoryNotFoundException(createProductDto.categoryId()));
        return DisplayProductDto.from(productService.create(createProductDto.toProduct(category)));
    }

    @Override
    @Transactional
    public Optional<DisplayProductDto> update(Long id, CreateProductDto createProductDto) {
        Category category = categoryService.findById(createProductDto.categoryId()).orElseThrow(() -> new CategoryNotFoundException(createProductDto.categoryId()));
        return productService.update(id, createProductDto.toProduct(category)).map(DisplayProductDto::from);
    }

    @Override
    public Optional<DisplayProductDto> deleteById(Long id) {
        return productService.deleteById(id).map(DisplayProductDto::from);
    }

    @Override
    public Page<DisplayProductDto> findAll(int page, int size, String sortBy) {
        return productService.findAll(page, size, sortBy)
                .map(DisplayProductDto::from);
    }
}
