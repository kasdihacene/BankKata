package com.bankkata;

import com.bankkata.domain.Article;

import java.math.BigDecimal;

public class BasketCalculator {

    public static BigDecimal calculate(Article article) {
        return article.calculate();
    }
}
