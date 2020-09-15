package com.bankkata.domain;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(price, price1.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return "Price{" +
                "price='" + price + '\'' +
                '}';
    }
}
