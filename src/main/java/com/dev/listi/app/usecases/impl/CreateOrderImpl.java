package com.dev.listi.app.usecases.impl;

import com.dev.listi.app.dto.CreateOSRequest;
import com.dev.listi.app.usecases.CreateOrder;
import com.dev.listi.domain.entities.Client;
import com.dev.listi.domain.entities.Order;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.repository.ClientRepository;
import com.dev.listi.domain.repository.OrdemServiceRepository;

import java.util.Optional;

import com.dev.listi.domain.repository.UserRepository;

import com.dev.listi.infra.db.mapper.OrderMapper;
import com.dev.listi.infra.db.model.ClientModel;
import com.dev.listi.infra.db.model.UserModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CreateOrderImpl implements CreateOrder {

    @Inject
    OrdemServiceRepository orderRepository;

    @Inject
    ClientRepository clientRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    OrderMapper orderMapper;

    @Override
    @Transactional
    public Optional<Order> execute(CreateOSRequest createOSRequest) {

        Order order = orderMapper.createOSRequestToOrder(createOSRequest);
        Optional<UserModel> userModel = userRepository.getUserById(String.valueOf(createOSRequest.idUser()));
        Optional<ClientModel> clientModel = clientRepository.findById(Long.valueOf(createOSRequest.idClient()));

        if (userModel.isEmpty()) {
            throw new RuntimeException("Usuario nao existe");
        }

        if (clientModel.isEmpty()) {
            throw new RuntimeException("Cliente nao existe");
        }

        orderRepository.createOrder(order, userModel.get(),  clientModel.get());

        return Optional.of(order);
    }
}