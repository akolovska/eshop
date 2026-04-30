package mk.finki.ukim.eshop.repository;

import mk.finki.ukim.eshop.model.views.ProductCatalogView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatalogViewRepository extends JpaRepository<ProductCatalogView, Long> {
    @Modifying
    @Query(value = "call refresh_product_catalog_view()", nativeQuery = true)
    void refresh();
}
