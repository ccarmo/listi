package com.dev.listi.app.usecases;



import java.util.Optional;

public interface CreateAccount {
    Optional<UserRecord> createUser(String name);
}