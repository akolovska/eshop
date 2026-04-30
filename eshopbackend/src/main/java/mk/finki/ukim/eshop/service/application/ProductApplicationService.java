package mk.finki.ukim.eshop.service.application;

import mk.finki.ukim.eshop.model.dto.CreateProductDto;
import mk.finki.ukim.eshop.model.dto.DisplayProductDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ProductApplicationService {
    Optional<DisplayProductDto> findById(Long id);

    List<DisplayProductDto> findAll();

    DisplayProductDto create(CreateProductDto createProductDto);

    Optional<DisplayProductDto> update(Long id, CreateProductDto createProductDto);

    Optional<DisplayProductDto> deleteById(Long id);
    Page<DisplayProductDto> findAll(int page, int size, String sortBy);
}
