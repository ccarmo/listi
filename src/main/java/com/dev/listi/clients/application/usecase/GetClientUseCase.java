package com.dev.listi.clients.application.usecase;

import com.dev.listi.clients.application.dto.ClientRecord;
import com.dev.listi.clients.infra.db.model.ClientModel;

import java.util.List;
import java.util.Optional;


public interface GetClientUseCase {
    Optional<ClientRecord> getClient(String idClient);
    List<ClientRecord> listAllClients(String idClient);
    Optional<ClientModel> getClientModel(String idClient);
}
