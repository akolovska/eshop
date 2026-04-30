package mk.finki.ukim.eshop.service.application;

import mk.finki.ukim.eshop.model.dto.DisplayProductCatalogViewDto;

import java.util.List;

public interface ProductCatalogViewServiceApplication {
    List<DisplayProductCatalogViewDto> findAll();
}
