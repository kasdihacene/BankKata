package com.bankkata.domain;

import java.math.BigDecimal;

public class Quantity {

    private int quantity;

    private Quantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal multiply(String price) {
        return new BigDecimal(price).multiply(BigDecimal.valueOf(quantity));
    }

    public static class Builder {
        private int quantity;

        public Builder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Quantity build() {
            return new Quantity(quantity);
        }
    }
}
