package mk.finki.ukim.eshop.web.controller;

import mk.finki.ukim.eshop.model.dto.CreateProductDto;
import mk.finki.ukim.eshop.model.dto.DisplayCategoryDto;
import mk.finki.ukim.eshop.model.dto.DisplayProductDto;
import mk.finki.ukim.eshop.service.application.CategoryApplicationService;
import mk.finki.ukim.eshop.service.application.ProductApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductApplicationService productApplicationService;
    private final CategoryApplicationService categoryApplicationService;

    public ProductController(ProductApplicationService productApplicationService, CategoryApplicationService categoryApplicationService) {
        this.productApplicationService = productApplicationService;
        this.categoryApplicationService = categoryApplicationService;
    }
    @GetMapping("/paginated")
    public ResponseEntity<Page<DisplayProductDto>> findAll(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int size,
                                                           @RequestParam(defaultValue = "name") String sortBy) {
        return ResponseEntity.ok(productApplicationService.findAll(page, size, sortBy));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisplayProductDto> findById(@PathVariable Long id) {
        return productApplicationService
                .findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<DisplayProductDto>> findAll() {
        return ResponseEntity.ok(productApplicationService.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity<DisplayProductDto> create(@RequestBody CreateProductDto createProductDto) {
        return ResponseEntity.ok(productApplicationService.create(createProductDto));
    }
    @PutMapping("/{id}/edit")
    public ResponseEntity<DisplayProductDto> update(
            @PathVariable Long id,
            @RequestBody CreateProductDto createProductDto
    ) {
        return productApplicationService
                .update(id, createProductDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<DisplayProductDto> deleteById(@PathVariable Long id) {
        return productApplicationService
                .deleteById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
