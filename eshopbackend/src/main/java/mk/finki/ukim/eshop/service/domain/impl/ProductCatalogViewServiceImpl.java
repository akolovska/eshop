package mk.finki.ukim.eshop.service.domain.impl;

import mk.finki.ukim.eshop.model.views.ProductCatalogView;
import mk.finki.ukim.eshop.repository.ProductCatalogViewRepository;
import mk.finki.ukim.eshop.service.domain.ProductCatalogViewService;

import java.util.List;

public class ProductCatalogViewServiceImpl implements ProductCatalogViewService {
    private final ProductCatalogViewRepository productCatalogViewRepository;

    public ProductCatalogViewServiceImpl(ProductCatalogViewRepository productCatalogViewRepository) {
        this.productCatalogViewRepository = productCatalogViewRepository;
    }

    @Override
    public List<ProductCatalogView> findAll() {
        return productCatalogViewRepository.findAll();
    }
}
