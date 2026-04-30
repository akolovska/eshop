package mk.finki.ukim.eshop.service.application;

import mk.finki.ukim.eshop.model.dto.DisplayUserCartSummaryViewDto;

import java.util.List;

public interface UserCartSummaryViewServiceApplication {
    List<DisplayUserCartSummaryViewDto> findAll();
}
