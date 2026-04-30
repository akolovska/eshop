package mk.finki.ukim.eshop.model.dto;

import mk.finki.ukim.eshop.model.views.UserCartSummaryView;

import java.math.BigDecimal;
import java.util.List;

public record DisplayUserCartSummaryViewDto(
        String fullName,
        String email,
        Integer totalItems,
        Integer totalQuantity,
        BigDecimal totalPrice
) {
    public static DisplayUserCartSummaryViewDto from(UserCartSummaryView userCartSummaryView) {
        return new DisplayUserCartSummaryViewDto(
                userCartSummaryView.getFullName(),
                userCartSummaryView.getEmail(),
                userCartSummaryView.getTotalItems(),
                userCartSummaryView.getTotalQuantity(),
                userCartSummaryView.getTotalPrice()
        );
    }

    public static List<DisplayUserCartSummaryViewDto> from(List<UserCartSummaryView> userCartSummaryViews) {
        return userCartSummaryViews
                .stream()
                .map(DisplayUserCartSummaryViewDto::from)
                .toList();
    }
}

