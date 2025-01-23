package com.dev.listi.app.usecases;

import java.util.Optional;

public interface GetUserUseCase {

    Optional<UserDTO> getUser(String email);
}
