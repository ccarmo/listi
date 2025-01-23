package com.dev.listi.app.usecases;

import com.dev.listi.domain.entities.Order;
import com.dev.listi.domain.vo.StatusOS;
import java.util.Optional;

public interface ChangeOrderStatus {
    Optional<Order> execute(Long orderId, StatusOS newStatus);
}
