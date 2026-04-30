package mk.finki.ukim.eshop.web.controller;

import jakarta.validation.Valid;
import mk.finki.ukim.eshop.model.domain.Category;
import mk.finki.ukim.eshop.model.dto.CreateCategoryDto;
import mk.finki.ukim.eshop.model.dto.DisplayCategoryDto;
import mk.finki.ukim.eshop.model.dto.DisplayProductDto;
import mk.finki.ukim.eshop.service.application.CategoryApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryApplicationService applicationService;

    public CategoryController(CategoryApplicationService applicationService) {
        this.applicationService = applicationService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<DisplayCategoryDto> findById(@PathVariable Long id) {
        return applicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<DisplayCategoryDto>> findAll() {
        return ResponseEntity.ok(applicationService.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity<DisplayCategoryDto> create(@RequestBody @Valid CreateCategoryDto createCategoryDto) {
        return ResponseEntity.ok(applicationService.create(createCategoryDto));
    }
    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayCategoryDto> update(@PathVariable Long id,
                                                     @RequestBody CreateCategoryDto createCategoryDto) {
                return applicationService
                .update(id, createCategoryDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
