package com.dev.listi.user.application.usecase;

import com.dev.listi.user.application.dto.UserRecord;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public interface CreateUserUseCase {
    Optional<UserRecord> createUser(String name, String phone, String email);
}
