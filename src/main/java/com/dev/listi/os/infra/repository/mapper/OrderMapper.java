package com.dev.listi.os.infra.repository.mapper;

import com.dev.listi.os.application.dto.CreateOSRequest;
import com.dev.listi.os.core.entities.Order;
import com.dev.listi.os.infra.repository.model.OSDataModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface OrderMapper {


    @Mapping(source = "order.orderCode", target = "code")
    @Mapping(source = "order.description", target = "description")
    @Mapping(source = "order.creationDate", target = "creationDate")
    @Mapping(source = "order.status", target = "status")
    @Mapping(source = "order.notes", target = "notes")
    OSDataModel orderToOSDataModel(Order order);

    @Mapping(source = "osDataModel.id", target = "id")
    @Mapping(source = "osDataModel.code", target = "orderCode")
    @Mapping(source = "osDataModel.client.id", target = "clientId")
    @Mapping(source = "osDataModel.description", target = "description")
    @Mapping(source = "osDataModel.creationDate", target = "creationDate")
    @Mapping(source = "osDataModel.status", target = "status")
    @Mapping(source = "osDataModel.notes", target = "notes")
    Order osDataModelToOrder(OSDataModel osDataModel);

    @Mapping(source = "request.description", target = "description")
    @Mapping(source = "request.notes", target = "notes")
    Order createOSRequestToOrder(CreateOSRequest request);
}