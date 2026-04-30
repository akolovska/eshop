package mk.finki.ukim.eshop.repository;

import mk.finki.ukim.eshop.model.views.UserCartSummaryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCartSummaryViewRepository extends JpaRepository<UserCartSummaryView, Long> {
}

