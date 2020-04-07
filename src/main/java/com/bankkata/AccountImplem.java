package com.bankkata;

public class AccountImplem implements Account {

    private TransactionDouble transactionDouble;
    private TransactionCount transactionCount;

    public AccountImplem(TransactionDouble transactionDouble) {
        this.transactionDouble = transactionDouble;
    }

    public AccountImplem(TransactionCount transactionCount) {

        this.transactionCount = transactionCount;
    }

    @Override
    public void deposit(int amount) {
        if (transactionDouble != null)
            transactionDouble.deposit(amount);

        if (transactionCount != null)
            transactionCount.incrementNbTransactions();
    }

    @Override
    public void withdraw(int amount) {
        if (transactionDouble != null)
            transactionDouble.deposit(amount);

        if (transactionCount != null)
            transactionCount.incrementNbTransactions();
    }

    @Override
    public void printStatement() {

    }
}
