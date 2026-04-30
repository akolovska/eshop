package mk.finki.ukim.eshop.web.controller;

import mk.finki.ukim.eshop.model.dto.DisplayUserCartSummaryViewDto;
import mk.finki.ukim.eshop.service.application.UserCartSummaryViewServiceApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/user-cart-summary")
public class UserCartSummaryViewController {
    private final UserCartSummaryViewServiceApplication userCartSummaryViewServiceApplication;

    public UserCartSummaryViewController(UserCartSummaryViewServiceApplication userCartSummaryViewServiceApplication) {
        this.userCartSummaryViewServiceApplication = userCartSummaryViewServiceApplication;
    }
    @GetMapping
    public ResponseEntity<List<DisplayUserCartSummaryViewDto>> findAll() {
        return ResponseEntity.ok(userCartSummaryViewServiceApplication.findAll());
    }
}
