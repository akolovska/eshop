package mk.finki.ukim.eshop.service.application.impl;

import mk.finki.ukim.eshop.model.domain.Category;
import mk.finki.ukim.eshop.model.dto.CreateCategoryDto;
import mk.finki.ukim.eshop.model.dto.DisplayCategoryDto;
import mk.finki.ukim.eshop.model.dto.DisplayProductDto;
import mk.finki.ukim.eshop.model.exception.CategoryNotFoundException;
import mk.finki.ukim.eshop.repository.CategoryRepository;
import mk.finki.ukim.eshop.service.application.CategoryApplicationService;
import mk.finki.ukim.eshop.service.domain.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryApplicationServiceImpl implements CategoryApplicationService {
    private final CategoryService categoryService;

    public CategoryApplicationServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public Optional<DisplayCategoryDto> findById(Long id) {
        return categoryService.findById(id).map(DisplayCategoryDto::from);
    }

    @Override
    public List<DisplayCategoryDto> findAll() {
        return DisplayCategoryDto.from(categoryService.findAll());
    }

    @Override
    public DisplayCategoryDto create(CreateCategoryDto createCategoryDto) {
        Category category = createCategoryDto.toCategory();
        Category saved = categoryService.create(category);
        return DisplayCategoryDto.from(saved);
//        return DisplayCategoryDto.from(categoryService.create(createCategoryDto.toCategory()));
    }

    @Override
    public Optional<DisplayCategoryDto> update(Long id, CreateCategoryDto createCategoryDto) {
        return categoryService
                .update(id, createCategoryDto.toCategory())
                .map(DisplayCategoryDto::from);
    }

    @Override
    public Optional<DisplayCategoryDto> deleteById(Long id) {
        return categoryService
                .deleteById(id)
                .map(DisplayCategoryDto::from);
    }
}
