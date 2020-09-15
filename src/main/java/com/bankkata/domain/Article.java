package com.bankkata.domain;

import java.math.BigDecimal;

public class Article {

    private final String name;
    private final Price price;
    private final Quantity quantity;

    public Article(String name, Price price) {
        this.name = name;
        this.price = price;
        this.quantity = new Quantity(1);
    }

    public Article(String name, Price price, Quantity quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal calculate() {
        return price.multiply(quantity);
    }
}
