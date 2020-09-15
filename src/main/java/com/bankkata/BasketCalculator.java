package com.bankkata;

import com.bankkata.domain.Article;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasketCalculator {

    private List<Article> articles;

    private BasketCalculator() {
        this.articles = new ArrayList<>();
    }

    public static BasketCalculator instance() {
        return new BasketCalculator();
    }

    private BigDecimal compute(List<Article> articles) {
        return articles
                .stream()
                .map(Article::calculate)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal calculate(List<Article> articles) {
        return compute(articles);
    }

    public BigDecimal calculate() {
        return compute(this.articles);
    }

    public void add(Article snickers) {
        this.articles.add(snickers);
    }
}
