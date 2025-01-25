package com.dev.listi.app.usecases.impl;

import com.dev.listi.app.dto.CreateOSRequest;
import com.dev.listi.app.usecases.CreateOrder;
import com.dev.listi.domain.entities.Order;
import com.dev.listi.domain.repository.OrdemServiceRepository;

import java.util.Optional;

import com.dev.listi.infra.db.mapper.OrderMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
@ApplicationScoped
public class CreateOrderImpl implements CreateOrder {

    @Inject
    OrdemServiceRepository orderRepository;

    @Inject
    OrderMapper orderMapper;

    @Override
    public Optional<Order> execute(CreateOSRequest createOSRequest) {
        Order order = orderMapper.createOSRequestToOrder(createOSRequest);
        return orderRepository.createOrder(order);
    }
}