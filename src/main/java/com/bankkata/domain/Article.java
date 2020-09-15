package com.bankkata.domain;

import com.bankkata.visitor.ArticleVisitor;

import java.math.BigDecimal;

public abstract class Article {

    private final String name;
    private final Price price;
    private final Quantity quantity;

    public Article(String name, Price price, Quantity quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal calculate() {
        return price.multiply(quantity);
    }

    public boolean hasName(String articleName) {
        return name.equalsIgnoreCase(articleName);
    }

    public Price price() {
        return price;
    }

    public Article updateQuantity(String articleName) {
        boolean sameItemCode = this.hasName(articleName);
        if (sameItemCode) {
            quantity.decrease();
        }
        return this;
    }

    public boolean hasQuantity() {
        return quantity.containsItems();
    }

    public abstract void accept(ArticleVisitor visitor);
}
