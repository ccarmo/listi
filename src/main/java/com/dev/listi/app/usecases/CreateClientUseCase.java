package com.dev.listi.app.usecases;

import com.dev.listi.app.dto.CreateClientRequest;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface CreateClientUseCase {

    void createClient(CreateClientRequest createClientRequest);

}
