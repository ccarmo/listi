package com.dev.listi.os.core.repository;

import com.dev.listi.os.core.entities.Order;
import com.dev.listi.os.core.enums.StatusOS;
import com.dev.listi.clients.infra.db.model.ClientModel;
import com.dev.listi.os.infra.repository.model.OSDataModel;
import com.dev.listi.user.infra.db.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface OrdemServiceRepository {
    void createOrder(Order order, UserModel userModel, ClientModel clientModel);
    Optional<OSDataModel> changeOrderStatus(Long orderId, StatusOS status);
    Optional<OSDataModel> changeOrderTrackingLink(Long orderId, String link);
    Optional<OSDataModel> changeOrderManagementLink(Long orderId, String link);
    Optional<OSDataModel> changeNotes(Long orderId, String note);
    Optional<OSDataModel> changeDescription(Long orderId, String description);

}