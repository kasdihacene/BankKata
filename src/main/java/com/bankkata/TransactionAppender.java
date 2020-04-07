package com.bankkata;

@FunctionalInterface
public interface TransactionAppender {
    void append(Transaction transaction);
}
