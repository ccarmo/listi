package com.dev.listi.user.application.usecase;


import com.dev.listi.user.application.dto.UserRecord;
import com.dev.listi.user.infra.db.model.UserModel;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;
@ApplicationScoped
public interface GetUserUseCase {

    Optional<UserRecord> getUser(String idUser);
    Optional<UserModel> getUserModel(String idUser);
}
