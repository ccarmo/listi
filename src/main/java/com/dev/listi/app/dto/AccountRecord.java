package com.dev.listi.app.dto;


import com.dev.listi.domain.entities.TypeAccount;

public record AccountRecord(TypeAccount typeAccount, String idUser) {
}
