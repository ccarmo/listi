package com.dev.listi.domain.entities;

import com.dev.listi.domain.vo.StatusOS;
import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private Long id;
    private String orderCode;
    private String description;
    private LocalDateTime creationDate;
    private StatusOS status;
    private String notes;
    private Long serviceProviderId;
    private Long clientId;

    // Empty constructor
    public Order() {
    }

    // Constructor with all attributes
    public Order(Long id, String orderCode, String description, LocalDateTime creationDate, StatusOS status, String notes, Long serviceProviderId, Long clientId) {
        this.id = id;
        this.orderCode = orderCode;
        this.description = description;
        this.creationDate = creationDate;
        this.status = status;
        this.notes = notes;
        this.serviceProviderId = serviceProviderId;
        this.clientId = clientId;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public StatusOS getStatus() {
        return status;
    }

    public void setStatus(StatusOS status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(Long serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(id, orderCode, description, creationDate, status, notes, serviceProviderId, clientId);
    }

    // equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(orderCode, order.orderCode) &&
                Objects.equals(description, order.description) &&
                Objects.equals(creationDate, order.creationDate) &&
                status == order.status &&
                Objects.equals(notes, order.notes) &&
                Objects.equals(serviceProviderId, order.serviceProviderId) &&
                Objects.equals(clientId, order.clientId);
    }

    // toString method
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderCode='" + orderCode + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", status=" + status +
                ", notes='" + notes + '\'' +
                ", serviceProviderId=" + serviceProviderId +
                ", clientId=" + clientId +
                '}';
    }
}




