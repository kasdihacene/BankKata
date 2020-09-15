package com.bankkata.domain;

import java.math.BigDecimal;

public class Price {
    private String price;

    public Price(String price) {
        this.price = price;
    }


    public BigDecimal multiply(Quantity quantity) {
        return quantity.multiply(price);
    }
}
