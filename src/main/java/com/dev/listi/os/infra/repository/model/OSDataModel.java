package com.dev.listi.os.infra.repository.model;

import com.dev.listi.clients.infra.db.model.ClientModel;
import com.dev.listi.user.infra.db.model.UserModel;
import com.dev.listi.os.core.enums.StatusOS;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "os")
public class OSDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private ClientModel client;


    private String description;

    @Column(nullable = true)
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private StatusOS status;

    private String notes;

    private String managementLink;

    private String trackingLink;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ClientModel getClient() {
        return client;
    }

    public void setClient(ClientModel client) {
        this.client = client;
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

    public String getManagementLink() {
        return managementLink;
    }

    public void setManagementLink(String managementLink) {
        this.managementLink = managementLink;
    }

    public String getTrackingLink() {
        return trackingLink;
    }

    public void setTrackingLink(String trackingLink) {
        this.trackingLink = trackingLink;
    }
}