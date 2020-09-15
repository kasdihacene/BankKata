package com.bankkata.visitor;

import com.bankkata.articles.Bots;
import com.bankkata.articles.Shoes;
import com.bankkata.articles.Snickers;

import java.math.BigDecimal;

public interface ArticleVisitor {

    public BigDecimal visitTotal(Shoes shoes);
    public BigDecimal visitTotal(Snickers snickers);
    public BigDecimal visitTotal(Bots bots);
}
