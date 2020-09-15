package com.bankkata.articles;

import com.bankkata.domain.Article;
import com.bankkata.domain.Price;
import com.bankkata.domain.Quantity;
import com.bankkata.visitor.ArticleVisitor;

public class Shoes extends Article {
    public Shoes(String shoes, Price priceValue, Quantity quantity) {
        super(shoes,priceValue,quantity);
    }

    @Override
    public void accept(ArticleVisitor visitor) {
        visitor.visitTotal(this);
    }
}
