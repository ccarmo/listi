package com.dev.listi.app.usecases;

import java.math.BigDecimal;


public interface GetBalance {

    BigDecimal getBalance(String accountNumber);
}
