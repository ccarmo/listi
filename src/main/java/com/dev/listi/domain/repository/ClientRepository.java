package com.dev.listi.domain.repository;

import com.dev.listi.domain.entities.Client;
import com.dev.listi.domain.entities.User;
import com.dev.listi.infra.db.model.ClientModel;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    void save(Client client, User user);
    Optional<ClientModel> findById(Long id);
    List<Client> findAll();
    void delete(Long id);
    Optional<Client> update(Client client);

    // Métodos adicionais
    Optional<Client> deleteClient(Long id);
    List<Client> findByName(String name);
    Optional<ClientModel> findByEmail(String email);
}
