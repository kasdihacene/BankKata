package com.bankkata.domain;

import java.math.BigDecimal;

public class Article {

    private final String name;
    private final BigDecimal price;

    public Article(String name, double price) {
        this.name = name;
        this.price = new BigDecimal(price);
    }
}
