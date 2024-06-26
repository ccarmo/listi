package com.dev.listi.app.usecases;


import com.dev.listi.domain.entities.Statement;

import java.util.List;

public interface GetStatement {

    List<Statement> getStatement(String idAccount);
}
