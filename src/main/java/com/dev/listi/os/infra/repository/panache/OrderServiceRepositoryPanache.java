package com.dev.listi.os.infra.repository.panache;

import com.dev.listi.os.core.enums.StatusOS;
import com.dev.listi.os.infra.repository.model.OSDataModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderServiceRepositoryPanache implements PanacheRepository<OSDataModel> {

    //crie metodos para manipular a classe OrderServiceRepositoryImpl

    public Optional<OSDataModel> createOrder(OSDataModel osDataModel) {
        persistAndFlush(osDataModel);
        return Optional.of(osDataModel);
    }

    public Optional<OSDataModel> changeOrderStatus(Long orderId, StatusOS status) {
        OSDataModel osDataModel = findById(orderId);
        if (osDataModel != null) {
            osDataModel.setStatus(status);
            persist(osDataModel);
            return Optional.of(osDataModel);
        }
        return Optional.empty();
    }

    public Optional<OSDataModel> updateTrackingLink(Long orderId, String link) {
        OSDataModel osDataModel = findById(orderId);
        if (osDataModel != null) {
            osDataModel.setTrackingLink(link);
            persistAndFlush(osDataModel);
            return Optional.of(osDataModel);
        }
        return Optional.empty();
    }

    public Optional<OSDataModel> updateManagementLink(Long orderId, String link) {
        OSDataModel osDataModel = findById(orderId);
        if (osDataModel != null) {
            osDataModel.setManagementLink(link);
            persistAndFlush(osDataModel);
            return Optional.of(osDataModel);
        }
        return Optional.empty();
    }

    public Optional<OSDataModel> updateNote(Long orderId, String note) {
        OSDataModel osDataModel = findById(orderId);
        if (osDataModel != null) {
            osDataModel.setNotes(note);
            persistAndFlush(osDataModel);
            return Optional.of(osDataModel);
        }
        return Optional.empty();
    }

    public Optional<OSDataModel> updateDescription(Long orderId, String description) {
        OSDataModel osDataModel = findById(orderId);
        if (osDataModel != null) {
            osDataModel.setDescription(description);
            persistAndFlush(osDataModel);
            return Optional.of(osDataModel);
        }
        return Optional.empty();
    }



    public Optional<OSDataModel> updateOrder(OSDataModel osDataModel) {
        OSDataModel existingOrder = findById(osDataModel.getId());
        if (existingOrder != null) {
            existingOrder.setCode(osDataModel.getCode());
            existingOrder.setClient(osDataModel.getClient());
            existingOrder.setDescription(osDataModel.getDescription());
            existingOrder.setCreationDate(osDataModel.getCreationDate());
            existingOrder.setStatus(osDataModel.getStatus());
            existingOrder.setNotes(osDataModel.getNotes());
            existingOrder.setManagementLink(osDataModel.getManagementLink());
            existingOrder.setTrackingLink(osDataModel.getTrackingLink());
            persist(existingOrder);
            return Optional.of(existingOrder);
        }
        return Optional.empty();
    }


}
