package com.dev.listi.os.application.usecases.impl;

import com.dev.listi.clients.application.usecase.GetClientUseCase;
import com.dev.listi.os.application.dto.CreateOSRequest;
import com.dev.listi.os.application.CreateOrderUseCase;
import com.dev.listi.os.core.entities.Order;
import com.dev.listi.os.core.repository.OrdemServiceRepository;

import java.util.Optional;

import com.dev.listi.user.application.usecase.GetUserUseCase;

import com.dev.listi.os.infra.repository.mapper.OrderMapper;
import com.dev.listi.clients.infra.db.model.ClientModel;
import com.dev.listi.user.infra.db.model.UserModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    @Inject
    OrdemServiceRepository orderRepository;
    
    @Inject
    GetClientUseCase executeUseCaseClient;

    @Inject
    GetUserUseCase executeUseCaseUser;


    @Inject
    OrderMapper orderMapper;

    @Override
    @Transactional
    public Optional<Order> execute(CreateOSRequest createOSRequest) {

        Order order = orderMapper.createOSRequestToOrder(createOSRequest);

        Optional<ClientModel> clientModel = executeUseCaseClient.getClientModel(String.valueOf(createOSRequest.idClient()));


        Optional<UserModel> userModel = executeUseCaseUser.getUserModel(String.valueOf(createOSRequest.idUser()));

        if (userModel.isEmpty()) {
            throw new RuntimeException("Usuario nao existe");
        }

        if (clientModel.isEmpty()) {
            throw new RuntimeException("Cliente nao existe");
        }

        orderRepository.createOrder(order, userModel.get(), clientModel.get());

        return Optional.of(order);
    }
}