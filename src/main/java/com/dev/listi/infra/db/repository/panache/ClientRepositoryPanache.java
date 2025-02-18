package com.dev.listi.infra.db.repository.panache;

import com.dev.listi.domain.entities.User;
import com.dev.listi.infra.db.model.ClientModel;
import com.dev.listi.infra.db.model.UserModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientRepositoryPanache implements PanacheRepository<ClientModel> {

    @Inject
    UserRepositoryPanache userRepository;

    public Optional<ClientModel> findByName(String name) {
        return find("name", name).firstResultOptional();
    }

    public Optional<ClientModel> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    public Optional<ClientModel> createClient(ClientModel clientModel) {
        persist(clientModel);
        return Optional.of(clientModel);
    }

    public Optional<ClientModel> updateClient(Long idClient, String name) {
        ClientModel clientModel = findById(idClient);
        if (clientModel != null) {
            clientModel.setName(name);
            persist(clientModel);
            return Optional.of(clientModel);
        }
        return Optional.empty();
    }

    public Optional<ClientModel> deleteClient(Long idClient) {
        Optional<ClientModel> clientModel = findByIdOptional(idClient);
        clientModel.ifPresent(this::delete);
        return clientModel;
    }

    public List<ClientModel> listAllClients() {
        return listAll();
    }

    public Optional<ClientModel> findClientById(Long idClient) {
        return findByIdOptional(idClient);
    }

    public List<ClientModel> findByStatus(String status) {
        return list("status", status);
    }

    public Optional<ClientModel> updateClient(ClientModel clientModel) {
        ClientModel existingClient = findById(clientModel.getId());
        if (existingClient != null) {
            existingClient.setName(clientModel.getName());
            existingClient.setEmail(clientModel.getEmail());
            existingClient.setPhone(clientModel.getPhone());
            existingClient.setServiceOrders(clientModel.getServiceOrders());
            persist(existingClient);
            return Optional.of(existingClient);
        }
        return Optional.empty();
    }

    public List<ClientModel> findByUser(String userEmail) {
        Optional<UserModel> userModel = userRepository.findByEmail(userEmail);
        if (userModel.isPresent()) {
            return list("userModel.id", userModel.get().getId());
        }
        return new ArrayList<>();
    }



}