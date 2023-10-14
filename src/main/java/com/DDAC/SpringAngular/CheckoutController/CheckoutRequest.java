package com.DDAC.SpringAngular.CheckoutController;

import java.math.BigDecimal;

public class CheckoutRequest {
	
    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}