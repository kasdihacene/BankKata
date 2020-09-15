package com.bankkata;

import com.bankkata.domain.Article;

import java.math.BigDecimal;
import java.util.List;

public class BasketCalculator {

    public static BigDecimal calculate(Article article) {
        return article.calculate();
    }

    public static BigDecimal calculate(List<Article> articles) {
        return articles.stream().map(Article::calculate).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
    }
}
