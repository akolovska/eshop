package mk.finki.ukim.eshop.web.controller;

import mk.finki.ukim.eshop.model.dto.DisplayProductCatalogViewDto;
import mk.finki.ukim.eshop.service.application.ProductCatalogViewServiceApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product-catalog")
public class ProductCatalogViewController {
    private final ProductCatalogViewServiceApplication productCatalogViewApplicationService;

    public ProductCatalogViewController(ProductCatalogViewServiceApplication productCatalogViewApplicationService) {
        this.productCatalogViewApplicationService = productCatalogViewApplicationService;
    }

    @GetMapping("/")
    public ResponseEntity<List<DisplayProductCatalogViewDto>> findAll() {
        return ResponseEntity.ok(productCatalogViewApplicationService.findAll());
    }

}
