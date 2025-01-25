package com.dev.listi.infra.db.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.dev.listi.domain.entities.Order;
import com.dev.listi.domain.repository.OrdemServiceRepository;
import com.dev.listi.domain.vo.StatusOS;
import com.dev.listi.infra.db.mapper.OrderMapper;
import com.dev.listi.infra.db.model.OSDataModel;
import com.dev.listi.infra.db.repository.panache.OrderServiceRepositoryPanache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class OrderServiceRepositoryImpl implements OrdemServiceRepository {

    @Inject
    OrderServiceRepositoryPanache orderServiceRepositoryPanache;

    @Inject
    OrderMapper orderMapper;

    @Override
    public Optional<Order> createOrder(Order order) {
        OSDataModel osDataModel = orderMapper.orderToOSDataModel(order);
        orderServiceRepositoryPanache.createOrder(osDataModel);
        return Optional.of(order);
    }

    @Override
    public Optional<Order> changeOrderStatus(Long orderId, StatusOS status) {
        Optional<OSDataModel> osDataModel = orderServiceRepositoryPanache.changeOrderStatus(orderId, status);
        return osDataModel.map(orderMapper::osDataModelToOrder);
    }

    @Override
    public Optional<Order> findOrderById(Long orderId) {
        Optional<OSDataModel> osDataModel = orderServiceRepositoryPanache.findOrderById(orderId);
        return osDataModel.map(orderMapper::osDataModelToOrder);
    }

    @Override
    public Optional<Order> deleteOrder(Long orderId) {
        Optional<OSDataModel> osDataModel = orderServiceRepositoryPanache.deleteOrder(orderId);
        return osDataModel.map(orderMapper::osDataModelToOrder);
    }

    @Override
    public List<Order> findAll() {
        List<OSDataModel> osDataModels = orderServiceRepositoryPanache.listAllOrders();
        return osDataModels.stream()
                .map(orderMapper::osDataModelToOrder)
                .collect(Collectors.toList());
    }

    @Override
    public List<Order> findByStatus(StatusOS status) {
        List<OSDataModel> osDataModels = orderServiceRepositoryPanache.findByStatus(status);
        return osDataModels.stream()
                .map(orderMapper::osDataModelToOrder)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Order> updateOrder(Order order) {
        OSDataModel osDataModel = orderMapper.orderToOSDataModel(order);
        Optional<OSDataModel> updatedOsDataModel = orderServiceRepositoryPanache.updateOrder(osDataModel);
        return updatedOsDataModel.map(orderMapper::osDataModelToOrder);
    }
}