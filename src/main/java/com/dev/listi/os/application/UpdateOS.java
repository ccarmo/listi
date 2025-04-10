package com.dev.listi.os.application;

import com.dev.listi.os.core.enums.StatusOS;
import com.dev.listi.os.core.vo.Link;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface UpdateOS {

    void status(Long orderId, String status);
    void trackingLink(Long orderId, Link link);
    void managementLink(Long orderId, Link link);
    void notes(Long orderId, String notes);
    void description(Long orderId, String description);

}
