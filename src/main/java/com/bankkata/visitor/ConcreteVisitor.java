package com.bankkata.visitor;

import com.bankkata.articles.Bots;
import com.bankkata.articles.Shoes;
import com.bankkata.articles.Snickers;

import java.math.BigDecimal;

public class ConcreteVisitor implements ArticleVisitor {
    @Override
    public BigDecimal visitTotal(Shoes shoes) {
        return shoes.calculate();
    }

    @Override
    public BigDecimal visitTotal(Snickers snickers) {
        return snickers.calculate();
    }

    @Override
    public BigDecimal visitTotal(Bots bots) {
        return bots.calculate() ;
    }
}
