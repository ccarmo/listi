package com.dev.listi.clients.application.usecase;

import com.dev.listi.clients.application.dto.CreateClientRequest;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface CreateClientUseCase {

    void createClient(CreateClientRequest createClientRequest);

}
