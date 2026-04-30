package mk.finki.ukim.eshop.service.domain;

import mk.finki.ukim.eshop.model.views.ProductCatalogView;

import java.util.List;

public interface ProductCatalogViewService {
    List<ProductCatalogView> findAll();
}
