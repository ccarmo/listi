package com.dev.listi.domain.repository;

import com.dev.listi.domain.entities.Client;
import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    Optional<Client> save(Client client);
    Optional<Client> findById(Long id);
    List<Client> findAll();
    void delete(Long id);
    Optional<Client> update(Client client);

    // Métodos adicionais
    Optional<Client> deleteClient(Long id);
    List<Client> findByName(String name);
    Optional<Client> findByEmail(String email);
}
