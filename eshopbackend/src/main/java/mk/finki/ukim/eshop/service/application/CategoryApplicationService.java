package mk.finki.ukim.eshop.service.application;

import mk.finki.ukim.eshop.model.dto.CreateCategoryDto;
import mk.finki.ukim.eshop.model.dto.DisplayCategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryApplicationService {
    Optional<DisplayCategoryDto> findById(Long id);

    List<DisplayCategoryDto> findAll();

    DisplayCategoryDto create(CreateCategoryDto createCategoryDto);

    Optional<DisplayCategoryDto> update(Long id, CreateCategoryDto createCategoryDto);

    Optional<DisplayCategoryDto> deleteById(Long id);
}
