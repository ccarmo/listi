package com.dev.listi.domain.repository;

import com.dev.listi.domain.entities.Order;
import com.dev.listi.domain.vo.StatusOS;
import java.util.List;
import java.util.Optional;

public interface OrdemServiceRepository {
    Optional<Order> createOrder(Order order);
    Optional<Order> changeOrderStatus(Long orderId, StatusOS status);
    Optional<Order> findOrderById(Long orderId);
    Optional<Order> deleteOrder(Long orderId);

    // Métodos adicionais
    List<Order> findAll();
    List<Order> findByStatus(StatusOS status);
    Optional<Order> updateOrder(Order order);
}