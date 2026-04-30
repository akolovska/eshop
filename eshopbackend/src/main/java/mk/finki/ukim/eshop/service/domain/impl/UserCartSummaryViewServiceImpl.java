package mk.finki.ukim.eshop.service.domain.impl;
import mk.finki.ukim.eshop.model.views.UserCartSummaryView;
import mk.finki.ukim.eshop.repository.UserCartSummaryViewRepository;
import mk.finki.ukim.eshop.service.domain.UserCartSummaryViewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCartSummaryViewServiceImpl implements UserCartSummaryViewService {
    private final UserCartSummaryViewRepository userCartSummaryViewRepository;

    public UserCartSummaryViewServiceImpl(UserCartSummaryViewRepository userCartSummaryViewRepository) {
        this.userCartSummaryViewRepository = userCartSummaryViewRepository;
    }

    @Override
    public List<UserCartSummaryView> findAll() {
        return userCartSummaryViewRepository.findAll();
    }
}
