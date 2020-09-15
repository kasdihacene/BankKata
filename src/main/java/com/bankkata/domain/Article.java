package com.bankkata.domain;

import java.math.BigDecimal;

public class Article {

    private final String name;
    private final BigDecimal price;
    private final int quantity;

    public Article(String name, String price) {
        this.name = name;
        this.price = new BigDecimal(price);
        this.quantity = 1;
    }

    public Article(String name, String price, int quantity) {
        this.name = name;
        this.price = new BigDecimal(price);
        this.quantity = quantity;
    }

    public BigDecimal calculate() {
        return price.multiply(BigDecimal.valueOf(quantity));
    }
}
