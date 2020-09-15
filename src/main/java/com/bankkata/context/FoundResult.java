package com.bankkata.context;

import com.bankkata.domain.Price;

import java.util.Objects;

public class FoundResult extends Result {

    private Price price;

    public FoundResult(Price price) {
        super();
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoundResult that = (FoundResult) o;
        return Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    @Override
    public String toString() {
        return "FoundResult{" +
                "price=" + price +
                '}';
    }
}
