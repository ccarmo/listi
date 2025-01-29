package com.dev.listi.infra.db.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.dev.listi.domain.entities.Client;
import com.dev.listi.domain.entities.Order;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.repository.ClientRepository;
import com.dev.listi.domain.repository.OrdemServiceRepository;
import com.dev.listi.domain.repository.UserRepository;
import com.dev.listi.domain.vo.StatusOS;
import com.dev.listi.infra.db.mapper.OrderMapper;
import com.dev.listi.infra.db.model.ClientModel;
import com.dev.listi.infra.db.model.OSDataModel;
import com.dev.listi.infra.db.model.UserModel;
import com.dev.listi.infra.db.repository.panache.OrderServiceRepositoryPanache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OrderServiceRepositoryImpl implements OrdemServiceRepository {

    @Inject
    OrderServiceRepositoryPanache orderServiceRepositoryPanache;

    @Inject
    OrderMapper orderMapper;

    @Inject
    UserRepository userRepository;

    @Inject
    ClientRepository clientRepository;

    @Override
    @Transactional
    public void createOrder(Order order, UserModel userModel, ClientModel clientModel) {
        OSDataModel osDataModel = orderMapper.orderToOSDataModel(order);
        osDataModel.setClient(clientModel);
        osDataModel.setUser(userModel);
        orderServiceRepositoryPanache.createOrder(osDataModel);
    }

    @Override
    public Optional<OSDataModel> changeOrderStatus(Long orderId, StatusOS status) {
        Optional<OSDataModel> osDataModel = orderServiceRepositoryPanache.changeOrderStatus(orderId, status);
        return osDataModel;
    }

    @Override
    public Optional<OSDataModel> findOrderById(Long orderId) {
        Optional<OSDataModel> osDataModel = orderServiceRepositoryPanache.findOrderById(orderId);
        return osDataModel;
    }


    @Override
    public List<OSDataModel> findAll() {
        List<OSDataModel> osDataModels = orderServiceRepositoryPanache.listAllOrders();
        return osDataModels;
    }

    @Override
    public List<OSDataModel> findByStatus(StatusOS status) {
        List<OSDataModel> osDataModels = orderServiceRepositoryPanache.findByStatus(status);
        return osDataModels;
    }

    @Override
    public Optional<OSDataModel> updateOrder(Order order) {
        OSDataModel osDataModel = orderMapper.orderToOSDataModel(order);
        Optional<OSDataModel> updatedOsDataModel = orderServiceRepositoryPanache.updateOrder(osDataModel);
        return updatedOsDataModel;
    }
}