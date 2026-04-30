package mk.finki.ukim.eshop.service.domain;

import mk.finki.ukim.eshop.model.views.UserCartSummaryView;

import java.util.List;

public interface UserCartSummaryViewService {
    List<UserCartSummaryView> findAll();
}
