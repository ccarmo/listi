package com.dev.listi.domain.repository;

import com.dev.listi.domain.entities.Client;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.entities.Order;
import com.dev.listi.domain.vo.StatusOS;
import com.dev.listi.infra.db.model.ClientModel;
import com.dev.listi.infra.db.model.OSDataModel;
import com.dev.listi.infra.db.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface OrdemServiceRepository {
    void createOrder(Order order, UserModel userModel, ClientModel clientModel);
    Optional<OSDataModel> changeOrderStatus(Long orderId, StatusOS status);
    Optional<OSDataModel> findOrderById(Long orderId);

    // Métodos adicionais
    List<OSDataModel> findAll();
    List<OSDataModel> findByStatus(StatusOS status);
    Optional<OSDataModel> updateOrder(Order order);
}