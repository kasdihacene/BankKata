package com.bankkata.visitor;

public interface ArticleElement {
    public void accept(ArticleVisitor visitor);
}
