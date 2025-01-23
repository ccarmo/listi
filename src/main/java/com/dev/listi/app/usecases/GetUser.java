package com.dev.listi.app.usecases;


import com.dev.listi.app.dto.UserRecord;

import java.util.Optional;

public interface GetUser {

    Optional<UserRecord> getUser(String idUser);
}
