package mk.finki.ukim.eshop.service.application.impl;

import mk.finki.ukim.eshop.model.dto.DisplayProductCatalogViewDto;
import mk.finki.ukim.eshop.service.application.ProductCatalogViewServiceApplication;
import mk.finki.ukim.eshop.service.domain.ProductCatalogViewService;

import java.util.List;

public class ProductCatalogViewServiceApplicationImpl implements ProductCatalogViewServiceApplication {
    private final ProductCatalogViewService productCatalogViewService;

    public ProductCatalogViewServiceApplicationImpl(ProductCatalogViewService productCatalogViewService) {
        this.productCatalogViewService = productCatalogViewService;
    }

    @Override
    public List<DisplayProductCatalogViewDto> findAll() {
        return DisplayProductCatalogViewDto.from(productCatalogViewService.findAll());
    }
}
