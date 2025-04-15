package com.dev.listi.auth;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.container.ContainerRequestContext;

@RequestScoped
public class JwtContextProducer {

    @Context
    ContainerRequestContext context;

    @Produces
    @Phone
    public String producePhoneNumber() {
        return (String) context.getProperty("phoneNumber");
    }

    @Produces
    @Role
    public String produceRole() {
        return (String) context.getProperty("role");
    }

}
