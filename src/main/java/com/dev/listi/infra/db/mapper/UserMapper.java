package com.dev.listi.usermanagement.mapper;

import com.dev.listi.usermanagement.domain.User;
import com.dev.listi.ordermanagement.domain.vo.Email;
import com.dev.listi.usermanagement.infra.model.UserModel;
import org.mapstruct.*;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    @Mapping(source = "userModel.id", target = "idUser" )
    @Mapping(source = "userModel.name", target = "name" )
    @Mapping(source = "userModel.email", target = "email", qualifiedByName = "mapStringToEmail")
    User userModelToUser(UserModel userModel);


    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.idUser", target = "id")
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
