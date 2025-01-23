package com.dev.listi.app.usecases.impl;

import com.dev.listi.app.usecases.CreateOrder;
import com.dev.listi.domain.entities.Order;
import com.dev.listi.domain.repository.OrderRepository;
import java.util.Optional;
import jakarta.inject.Inject;

public class CreateOrderImpl implements CreateOrder {

    private final OrderRepository orderRepository;

    @Inject
    public CreateOrderImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Order> execute(Order order) {
        return orderRepository.save(order);
    }
}