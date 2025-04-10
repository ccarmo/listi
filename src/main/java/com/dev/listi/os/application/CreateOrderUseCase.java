package com.dev.listi.os.application;

import com.dev.listi.os.application.dto.CreateOSRequest;
import com.dev.listi.os.core.entities.Order;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public interface CreateOrderUseCase {
    Optional<Order> execute(CreateOSRequest order);
}
