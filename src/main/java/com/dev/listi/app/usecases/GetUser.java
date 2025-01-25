package com.dev.listi.app.usecases;


import com.dev.listi.app.dto.UserRecord;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
@ApplicationScoped
public interface GetUser {

    Optional<UserRecord> getUser(String idUser);
}
