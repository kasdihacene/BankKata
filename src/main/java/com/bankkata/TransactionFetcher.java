package com.bankkata;

import java.util.List;

@FunctionalInterface
public interface TransactionFetcher {
    List<Transaction> fetch();
}
