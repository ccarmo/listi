package com.dev.listi.infra.db.h2.mapper;

import com.dev.listi.domain.entities.User;
import com.dev.listi.infra.db.h2.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    @Mapping(source = "userModel.name", target = "name")
    User userModelToUser(UserModel userModel);

    @Mapping(source = "user.idUser", target = "id")
    @Mapping(source = "user.name", target = "name")
    UserModel userToUserModel(User user);
}
