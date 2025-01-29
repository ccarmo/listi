package com.dev.listi.infra.db.mapper;

import com.dev.listi.app.dto.CreateClientRequest;
import com.dev.listi.domain.entities.Client;
import com.dev.listi.domain.vo.Email;
import com.dev.listi.infra.db.model.ClientModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "cdi")
public interface ClientMapper {

    @Mapping(source = "clientModel.name", target = "name")
    @Mapping(source = "clientModel.email", target = "email", qualifiedByName = "mapStringToEmail")
    Client clientModelToClient(ClientModel clientModel);

    @Mapping(source = "client.name", target = "name")
    @Mapping(source = "client.email", target = "email", qualifiedByName = "mapEmailToString")
    ClientModel clientToClientModel(Client client);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email", qualifiedByName = "mapStringToEmail")
    Client createClientRequestToClient(CreateClientRequest createClientRequest);

    @Named("mapStringToEmail")
    default Email mapStringToEmail(String email) {
        return new Email(email);
    }

    @Named("mapEmailToString")
    default String mapEmailToString(Email email) {
        return email.getEmail();
    }

}