package com.bankkata.articles;

import com.bankkata.domain.Article;
import com.bankkata.domain.Price;
import com.bankkata.domain.Quantity;
import com.bankkata.visitor.ArticleVisitor;

import java.math.BigDecimal;

public class Snickers extends Article {
    public Snickers(String articleName, Price priceValue, Quantity quantity) {
        super(articleName,priceValue,quantity);
    }

    @Override
    public BigDecimal accept(ArticleVisitor visitor) {
        return visitor.visitTotal(this);
    }
}
