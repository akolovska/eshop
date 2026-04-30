package mk.finki.ukim.eshop.service.application.impl;

import mk.finki.ukim.eshop.model.dto.DisplayProductCatalogViewDto;
import mk.finki.ukim.eshop.model.dto.DisplayUserCartSummaryViewDto;
import mk.finki.ukim.eshop.service.application.UserCartSummaryViewServiceApplication;
import mk.finki.ukim.eshop.service.domain.UserCartSummaryViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCartSummaryViewServiceApplicationImpl implements UserCartSummaryViewServiceApplication {
    private final UserCartSummaryViewService userCartSummaryViewService;

    public UserCartSummaryViewServiceApplicationImpl(UserCartSummaryViewService userCartSummaryViewService) {
        this.userCartSummaryViewService = userCartSummaryViewService;
    }

    @Override
    public List<DisplayUserCartSummaryViewDto> findAll() {
        return DisplayUserCartSummaryViewDto.from(userCartSummaryViewService.findAll());
    }
}
