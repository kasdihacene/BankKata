package com.bankkata;

import java.util.List;

public class AccountImplem implements Account {

    private TransactionDouble transactionDouble;
    private TransactionCount transactionCount;
    private TransactionAppender transactionAppender;
    private TransactionFetcher transactionFetcher;
    private TransactionPrinter transactionPrinter;

    public AccountImplem(TransactionAppender transactionAppender, TransactionFetcher transactionFetcher, TransactionPrinter transactionPrinter) {

        this.transactionAppender = transactionAppender;
        this.transactionFetcher = transactionFetcher;
        this.transactionPrinter = transactionPrinter;
    }

    public AccountImplem(TransactionDouble transactionDouble, TransactionCount transactionCount) {

        this.transactionDouble = transactionDouble;
        this.transactionCount = transactionCount;
    }

    @Override
    public void deposit(int amount) {
        apply(amount, TransactionType.DEPOSIT);
    }


    @Override
    public void withdraw(int amount) {
        apply(amount, TransactionType.WITHDRAWAL);
    }

    private void apply(int amount, TransactionType withdrawal) {
        if (transactionDouble != null)
            transactionDouble.transaction(amount);

        if (transactionCount != null)
            transactionCount.incrementNbTransactions();

        if (transactionAppender != null)
            transactionAppender.append(Transaction.instance().withDate("06/02/2020").withAmount(amount).withTransactionType(withdrawal).build());
    }

    @Override
    public void printStatement() {
        // We have to fetch transactions
        List<Transaction> fetchedTransactions = transactionFetcher.fetch();
        // Print transactions
        transactionPrinter.print(fetchedTransactions);
    }
}
