package com.bankkata.visitor;

import com.bankkata.articles.Bots;
import com.bankkata.articles.Shoes;
import com.bankkata.articles.Snickers;

public interface ArticleVisitor {

    public void visitTotal(Shoes shoes);
    public void visitTotal(Snickers snickers);
    public void visitTotal(Bots bots);
}
