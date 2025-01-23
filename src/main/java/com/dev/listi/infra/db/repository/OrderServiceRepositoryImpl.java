
package com.dev.listi.infra.db.repository;

import java.util.List;
import java.util.Optional;

import com.dev.listi.domain.repository.OrdemServiceRepository;




public class OrderServiceRepositoryImpl implements OrdemServiceRepository {
    @Override
    public List<OrderService> findAll() {
        // Implementation code here
        return null;
    }

    @Override
    public Optional<OrderService> findById(Long id) {
        // Implementation code here
        return Optional.empty();
    }

    @Override
    public OrderService save(OrderService orderService) {
        // Implementation code here
        return null;
    }

    @Override
    public void deleteById(Long id) {
        // Implementation code here
    }
}