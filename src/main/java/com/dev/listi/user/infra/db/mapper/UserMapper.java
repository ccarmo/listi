package com.dev.listi.user.infra.db.mapper;

import com.dev.listi.user.application.dto.UserRecord;
import com.dev.listi.user.core.entities.User;
import com.dev.listi.shared.core.vo.Email;
import com.dev.listi.user.infra.db.model.UserModel;
import org.mapstruct.*;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    @Mapping(source = "userModel.name", target = "name" )
    @Mapping(source = "userModel.email", target = "email", qualifiedByName = "mapStringToEmail")
    User userModelToUser(UserModel userModel);


    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.email", target = "email", qualifiedByName = "mapEmailToString")
    UserModel userToUserModel(User user);

    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.email", target = "email", qualifiedByName = "mapEmailToString")
    UserRecord userToUserDTO(User user);


    @Named("mapStringToEmail")
    default Email mapStringToEmail(String email) {
        return new Email(email);
    }

    @Named("mapEmailToString")
    default String mapEmailToString(Email email) {
        return email.getEmail();
    }

}