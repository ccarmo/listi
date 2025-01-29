package com.dev.listi.app.usecases.impl;

import com.dev.listi.app.dto.CreateClientRequest;
import com.dev.listi.app.usecases.CreateClientUseCase;
import com.dev.listi.domain.entities.Client;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.vo.Email;
import com.dev.listi.infra.db.mapper.ClientMapper;

import com.dev.listi.infra.db.repository.ClientRepository;

import com.dev.listi.infra.db.repository.UserRepository;
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