package com.dev.listi.app.usecases;

import com.dev.listi.domain.entities.Order;
import java.util.Optional;

public interface CreateOrder {
    Optional<Order> execute(Order order);
}
