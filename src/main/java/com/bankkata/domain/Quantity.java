package com.bankkata.domain;

import java.math.BigDecimal;

public class Quantity {

    private int quantity;

    public Quantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal multiply(String price) {
        return new BigDecimal(price).multiply(BigDecimal.valueOf(quantity));
    }
}
