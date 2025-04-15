package com.dev.listi.clients.application.usecase.impl;

import com.dev.listi.auth.Phone;

import com.dev.listi.clients.application.dto.CreateClientRequest;
import com.dev.listi.clients.application.usecase.CreateClientUseCase;
import com.dev.listi.clients.core.entities.Client;
import com.dev.listi.user.application.usecase.GetUserUseCase;
import com.dev.listi.user.core.entities.User;
import com.dev.listi.shared.core.vo.ContactNumber;
import com.dev.listi.shared.core.vo.Email;
import com.dev.listi.clients.infra.db.mapper.ClientMapper;
import com.dev.listi.clients.infra.db.repository.ClientRepository;
import com.dev.listi.user.core.repository.UserRepository;
import com.dev.listi.user.core.exception.UserNotFoundException;
import com.dev.listi.user.infra.db.mapper.UserMapper;
import com.dev.listi.user.infra.db.model.UserModel;
import com.dev.listi.clients.infra.db.model.ClientModel;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
public class CreateClientUseCaseImpl implements CreateClientUseCase {

    private static final Logger logger = Logger.getLogger(CreateClientUseCase.class.getName());

    @Inject
    ClientRepository clientRepository;

    @Inject
    GetUserUseCase getUserUseCase;

    @Inject
    @Phone
    private String phoneNumber;

  

    @Inject
    ClientMapper clientMapper;

    @Transactional
    public void createClient(CreateClientRequest createClientRequest) {
        logger.info("Iniciando criação de cliente");
        logger.fine("Número do telefone do token: " + phoneNumber.substring(0, 3) + "***");

        // Verifica se já existe um cliente com este email
        Optional<ClientModel> existingClient = clientRepository.findByEmail(createClientRequest.email());
        if (existingClient.isPresent()) {
            logger.warning("Cliente já existe com este email");
            return;
        }

        // Busca o usuário pelo phone do token
        Optional<UserModel> userModel = getUserUseCase.findUserByPhoneNumber(phoneNumber);
        if (userModel.isEmpty()) {
            logger.warning("Usuário não encontrado para o phone: " + phoneNumber);
            throw new UserNotFoundException("Usuário não encontrado para o phone: " + phoneNumber);
        }

        ContactNumber contactNumber = new ContactNumber(phoneNumber);
        Email email = new Email(createClientRequest.email());

        // Cria novo cliente
        Client newClient = new Client();
        newClient.setName(createClientRequest.name());
        newClient.setContactNumber(contactNumber);
        newClient.setEmail(email);
        
        clientRepository.save(newClient, userModel.get());
        logger.info("Cliente criado com sucesso");
    }
}