package mk.finki.ukim.eshop.model.exception;

public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String productName) {
        super("Not enough stock for %s.".formatted(productName));
    }
}

