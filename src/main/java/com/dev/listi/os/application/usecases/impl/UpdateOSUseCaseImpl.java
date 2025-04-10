package com.dev.listi.os.application.usecases.impl;

import com.dev.listi.os.application.UpdateOS;
import com.dev.listi.os.core.enums.StatusOS;
import com.dev.listi.os.core.vo.Link;
import com.dev.listi.os.infra.repository.OrderServiceRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdateOSUseCaseImpl implements UpdateOS {

    @Inject
    OrderServiceRepositoryImpl orderServiceRepository;

    @Override
    public void status(Long orderId, String status) {
        StatusOS statusOS = StatusOS.valueOf(status);
        orderServiceRepository.changeOrderStatus(orderId, statusOS);
    }

    @Override
    public void trackingLink(Long orderId, Link link) {
        String linkString = link.getPathString();
        orderServiceRepository.changeOrderTrackingLink(orderId, linkString);
    }


    @Override
    public void managementLink(Long orderId, Link link) {
        String linkString = link.getPathString();
        orderServiceRepository.changeOrderManagementLink(orderId, linkString);
    }

    @Override
    public void notes(Long orderId, String notes) {
        orderServiceRepository.changeNotes(orderId, notes);

    }

    @Override
    public void description(Long orderId, String description) {
        orderServiceRepository.changeDescription(orderId, description);
    }


}
