package com.dev.listi.clients.application.usecase.impl;

import com.dev.listi.clients.application.dto.ClientRecord;
import com.dev.listi.clients.application.usecase.GetClientUseCase;
import com.dev.listi.clients.core.entities.Client;
import com.dev.listi.clients.core.exception.ClientNotFoundException;
import com.dev.listi.clients.core.repository.ClientRepository;
import com.dev.listi.clients.infra.db.mapper.ClientMapper;
import com.dev.listi.clients.infra.db.model.ClientModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class GetClientUseCaseImpl implements GetClientUseCase {

    @Inject
    ClientRepository clientRepository;

    @Inject
    ClientMapper clientMapper;

    @Override
    public Optional<ClientRecord> getClient(String idClient) {
        Optional<ClientModel> clientModel = clientRepository.findById(Long.valueOf(idClient));

        if(clientModel.isEmpty()) {
            throw new ClientNotFoundException("Client not found for number: " + idClient);
        } else {
            Client client = clientMapper.clientModelToClient(clientModel.get());
            ClientRecord clientRecord = clientMapper.clientToClientDTO(client);
            return Optional.of(clientRecord);
        }
    }

    @Override
    public List<ClientRecord> listAllClients(String userEmail) {
        List<Client> clients = clientRepository.findByUser(userEmail);
        List<ClientRecord> clientRecord = new ArrayList<>();
        clients.stream().forEach(client -> {
            clientRecord.add(clientMapper.clientToClientDTO(client));
        });
        return clientRecord;
    }

    @Override
    public Optional<ClientModel> getClientModel(String idClient) {
        Optional<ClientModel> clientModel = clientRepository.findById(Long.valueOf(idClient));

        if(clientModel.isEmpty()) {
            throw new ClientNotFoundException("Client not found for number: " + idClient);
        }

        return clientModel;
    }

}
