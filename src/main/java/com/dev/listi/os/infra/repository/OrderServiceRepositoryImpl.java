package com.dev.listi.os.infra.repository;

import java.util.Optional;

import com.dev.listi.os.core.entities.Order;
import com.dev.listi.clients.core.repository.ClientRepository;
import com.dev.listi.os.core.repository.OrdemServiceRepository;
import com.dev.listi.user.core.repository.UserRepository;
import com.dev.listi.os.core.enums.StatusOS;
import com.dev.listi.os.infra.repository.mapper.OrderMapper;
import com.dev.listi.clients.infra.db.model.ClientModel;
import com.dev.listi.os.infra.repository.model.OSDataModel;
import com.dev.listi.user.infra.db.model.UserModel;
import com.dev.listi.os.infra.repository.panache.OrderServiceRepositoryPanache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class OrderServiceRepositoryImpl implements OrdemServiceRepository {

    @Inject
    OrderServiceRepositoryPanache orderServiceRepositoryPanache;

    @Inject
    OrderMapper orderMapper;

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
        return orderServiceRepositoryPanache.changeOrderStatus(orderId, status);
    }

    @Override
    public Optional<OSDataModel> changeOrderTrackingLink(Long orderId, String link) {
        return orderServiceRepositoryPanache.updateTrackingLink(orderId, link);
    }

    @Override
    public Optional<OSDataModel> changeOrderManagementLink(Long orderId, String link) {
        return orderServiceRepositoryPanache.updateManagementLink(orderId, link);
    }

    @Override
    public Optional<OSDataModel> changeNotes(Long orderId, String note) {
        return orderServiceRepositoryPanache.updateNote(orderId, note);
    }

    @Override
    public Optional<OSDataModel> changeDescription(Long orderId, String description) {
        return orderServiceRepositoryPanache.updateDescription(orderId, description);
    }


}