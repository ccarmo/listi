package com.dev.listi.infra.db.h2.mapper;

import com.dev.listi.app.dto.UserDTO;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.vo.Email;
import com.dev.listi.infra.db.h2.model.UserModel;
import org.mapstruct.*;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    @Mapping(source = "userModel.name", target = "name" )
    @Mapping(source = "userModel.email", target = "email", qualifiedByName = "mapStringToEmail")
    User userModelToUser(UserModel userModel);

    @Mapping(source = "userModel.name", target = "name" )
    @Mapping(source = "userModel.email", target = "email")
    UserDTO userModelToUserDTO(UserModel userModel);

    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.idUser", target = "id")
    @Mapping(source = "user.email", target = "email", qualifiedByName = "mapEmailToString")
    UserModel userToUserModel(User user);


    @Named("mapStringToEmail")
    default Email mapStringToEmail(String email) {
        return new Email(email);
    }

    @Named("mapEmailToString")
    default String mapEmailToString(Email email) {
        return email.getEmail();
    }

}
