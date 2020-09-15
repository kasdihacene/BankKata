package com.bankkata.domain;

import java.math.BigDecimal;

public class Price {

    private String price;

    private Price(String price) {
        this.price = price;
    }

    public BigDecimal multiply(Quantity quantity) {
        return quantity.multiply(price);
    }

    public static class Builder {
        private String price;

        public Builder withPrice(String price) {
            this.price = price;
            return this;
        }

        public Price build() {
            return new Price(price);
        }
    }
}
