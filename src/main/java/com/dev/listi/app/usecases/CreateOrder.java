package com.dev.listi.app.usecases;

import com.dev.listi.app.dto.CreateOSRequest;
import com.dev.listi.domain.entities.Order;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public interface CreateOrder {
    Optional<Order> execute(CreateOSRequest order);
}
