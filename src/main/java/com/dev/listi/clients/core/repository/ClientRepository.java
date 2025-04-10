package com.dev.listi.clients.core.repository;

import com.dev.listi.clients.core.entities.Client;
import com.dev.listi.user.core.entities.User;
import com.dev.listi.clients.infra.db.model.ClientModel;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    void save(Client client, User user);
    Optional<ClientModel> findById(Long id);
    List<Client> findAll();
    void delete(Long id);
    Optional<Client> update(Client client);
    List<Client> findByUser(String userEmail);

    // Métodos adicionais
    Optional<Client> deleteClient(Long id);
    List<Client> findByName(String name);
    Optional<ClientModel> findByEmail(String email);
}
