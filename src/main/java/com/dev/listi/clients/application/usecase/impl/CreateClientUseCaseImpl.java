package com.dev.listi.clients.application.usecase.impl;

import com.dev.listi.clients.application.dto.CreateClientRequest;
import com.dev.listi.clients.application.usecase.CreateClientUseCase;
import com.dev.listi.clients.core.entities.Client;
import com.dev.listi.user.core.entities.User;
import com.dev.listi.shared.core.vo.Email;
import com.dev.listi.clients.infra.db.mapper.ClientMapper;

import com.dev.listi.clients.infra.db.repository.ClientRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CreateClientUseCaseImpl implements CreateClientUseCase {

    @Inject
    ClientRepository clientRepository;



    @Inject
    ClientMapper clientMapper;

    @Transactional
    public void createClient(CreateClientRequest createClientRequest) {
        Client client = clientMapper.createClientRequestToClient(createClientRequest);
        Email email = new Email("teste@teste.com");
        User user = new User("Joao", email);


        clientRepository.save(client, user);
    }
}