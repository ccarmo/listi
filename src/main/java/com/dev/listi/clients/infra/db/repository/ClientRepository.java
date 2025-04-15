package com.dev.listi.clients.infra.db.repository;

import com.dev.listi.clients.core.entities.Client;
import com.dev.listi.user.core.entities.User;
import com.dev.listi.clients.infra.db.model.ClientModel;
import com.dev.listi.user.infra.db.model.UserModel;
import com.dev.listi.clients.infra.db.panache.ClientRepositoryPanache;
import com.dev.listi.clients.infra.db.mapper.ClientMapper;
import com.dev.listi.user.infra.db.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class ClientRepository implements com.dev.listi.clients.core.repository.ClientRepository {

    @Inject
    ClientRepositoryPanache clientRepositoryPanache;

    @Inject
    ClientMapper clientMapper;

    @Override
    @Transactional
    public void save(Client client, UserModel userModel) {

        ClientModel clientModel = clientMapper.clientToClientModel(client);
        clientModel.setUserModel(userModel);
        clientRepositoryPanache.createClient(clientModel);

    }

    @Override
    @Transactional
    public Optional<ClientModel> findById(Long id) {
        return clientRepositoryPanache.findClientById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepositoryPanache.listAllClients().stream()
                .map(clientMapper::clientModelToClient)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        clientRepositoryPanache.deleteClient(id);
    }

    @Override
    public Optional<Client> update(Client client) {
        ClientModel clientModel = clientMapper.clientToClientModel(client);
        return clientRepositoryPanache.updateClient(clientModel)
                .map(clientMapper::clientModelToClient);
    }

    @Override
    public Optional<Client> deleteClient(Long id) {
        return clientRepositoryPanache.deleteClient(id)
                .map(clientMapper::clientModelToClient);
    }

    @Override
    public List<Client> findByName(String name) {
        return clientRepositoryPanache.findByName(name).stream()
                .map(clientMapper::clientModelToClient)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ClientModel> findByEmail(String email) {
        return clientRepositoryPanache.findByEmail(email);
    }

    @Override
    public Optional<Client> findByPhone(String phone) {
        return clientRepositoryPanache.find("phone", phone).firstResultOptional()
                .map(clientMapper::clientModelToClient);
    }

    @Override
    public List<Client> findByUser(String userEmail) {
        return clientRepositoryPanache.findByUser(userEmail).stream()
                .map(clientMapper::clientModelToClient)
                .collect(Collectors.toList());
    }

}