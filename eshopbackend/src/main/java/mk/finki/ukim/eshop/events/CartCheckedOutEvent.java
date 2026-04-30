package mk.finki.ukim.eshop.events;

import mk.finki.ukim.eshop.model.domain.ShoppingCart;

public record CartCheckedOutEvent(ShoppingCart shoppingCart, String userEmail) {
}
