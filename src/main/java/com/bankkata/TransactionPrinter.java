package com.bankkata;

import java.util.List;

@FunctionalInterface
public interface TransactionPrinter {
    void print(List<Transaction> transactions);
}
