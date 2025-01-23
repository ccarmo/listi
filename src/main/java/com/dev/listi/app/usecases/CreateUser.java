package com.dev.listi.app.usecases;



import com.dev.listi.app.dto.UserRecord;

import java.util.Optional;

public interface CreateUser {
    Optional<UserRecord> createUser(String name);
}
