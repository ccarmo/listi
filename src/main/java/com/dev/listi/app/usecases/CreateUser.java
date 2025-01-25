package com.dev.listi.app.usecases;



import com.dev.listi.app.dto.UserRecord;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
@ApplicationScoped
public interface CreateUser {
    Optional<UserRecord> createUser(String name);
}
