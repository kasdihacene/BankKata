package com.bankkata.articles;

import com.bankkata.domain.Article;
import com.bankkata.domain.Price;
import com.bankkata.domain.Quantity;
import com.bankkata.visitor.ArticleVisitor;

public class Bots extends Article {
    public Bots(String articleName, Price priceValue, Quantity quantity) {
        super(articleName, priceValue, quantity);
    }

    @Override
    public void accept(ArticleVisitor visitor) {
        visitor.visitTotal(this);
    }
}
