package com.dev.listi.infra.db.repository.panache;

import com.dev.listi.domain.vo.StatusOS;
import com.dev.listi.infra.db.model.OSDataModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class OrderServiceRepositoryPanache implements PanacheRepository<OSDataModel> {

    //crie metodos para manipular a classe OrderServiceRepositoryImpl

    public Optional<OSDataModel> createOrder(OSDataModel osDataModel) {
        persist(osDataModel);
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

    public Optional<OSDataModel> findOrderById(Long orderId) {
        return findByIdOptional(orderId);
    }

    public Optional<OSDataModel> deleteOrder(Long orderId) {
        Optional<OSDataModel> osDataModel = findByIdOptional(orderId);
        osDataModel.ifPresent(this::delete);
        return osDataModel;
    }

    public List<OSDataModel> listAllOrders() {
        return listAll();
    }

    public List<OSDataModel> findByStatus(StatusOS status) {
        return list("status", status);
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
