package com.dev.listi.app.usecases;


import java.util.Optional;

public interface GetUser {

    Optional<UserRecord> getUser(String idUser);
}
