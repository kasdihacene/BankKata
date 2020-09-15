package com.bankkata;

import com.bankkata.domain.Article;
import com.bankkata.domain.Price;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public Price fetch(String articleName) {
        Optional<Article> found = articles.stream().filter(article -> article.hasName(articleName)).findFirst();
        return found.map(Article::price).orElse(null);

    }

    public void remove(String articleName) {
        articles = articles.stream()
                .map(article -> article.updateQuantity(articleName))
                .filter(Article::hasQuantity).collect(Collectors.toList());
    }

}
