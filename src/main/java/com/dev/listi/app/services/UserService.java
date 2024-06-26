package com.dev.listi.app.services;

import com.dev.listi.app.dto.UserDTO;
import com.dev.listi.app.dto.UserRecord;
import com.dev.listi.app.usecases.CreateUserUseCase;
import com.dev.listi.app.usecases.GetUserUseCase;
import com.dev.listi.app.usecases.impl.CreateUserImpl;
import com.dev.listi.app.usecases.impl.GetUserImpl;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.exceptions.UserNotFoundException;
import com.dev.listi.domain.vo.Email;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@ApplicationScoped
public class UserService {
    @Inject
    private GetUserImpl getUserImpl;

    @Inject
    private CreateUserImpl createUserImpl;

    public Response createUser(String name) {

        Optional<UserRecord> userRecord = createUserImpl.createUser(name);
        return Response.ok(userRecord.get()).build();
    }

    public Response getUser(@QueryParam("email") String email) {
        Optional<UserRecord> user = getUserImpl.getUser(email);
        return Response.ok(user.get()).build();
    }
}
