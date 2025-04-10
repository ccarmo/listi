package com.dev.listi.os.application;

import com.dev.listi.os.core.entities.Order;
import com.dev.listi.os.core.enums.StatusOS;
import java.util.Optional;

public interface ChangeOrderStatus {
    Optional<Order> execute(Long orderId, StatusOS newStatus);
}
