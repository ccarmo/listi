package com.dev.listi.app.usecases;

import com.dev.listi.app.dto.ClientRecord;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;


public interface GetClientUseCase {
    Optional<ClientRecord> getClient(String idClient);
    List<ClientRecord> listAllClients(String idClient);
}
