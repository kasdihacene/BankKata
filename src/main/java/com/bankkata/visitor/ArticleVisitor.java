package com.bankkata.visitor;

import com.bankkata.articles.Bots;
import com.bankkata.articles.Shoes;
import com.bankkata.articles.Snickers;

import java.math.BigDecimal;

public interface ArticleVisitor {

    BigDecimal visitTotal(Shoes shoes);

    BigDecimal visitTotal(Snickers snickers);

    BigDecimal visitTotal(Bots bots);
}
