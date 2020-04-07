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
        apply(amount);
    }


    @Override
    public void withdraw(int amount) {
        apply(amount);
    }

    private void apply(int amount) {
        if (transactionDouble != null)
            transactionDouble.transaction(amount);

        if (transactionCount != null)
            transactionCount.incrementNbTransactions();
    }

    @Override
    public void printStatement() {

    }
}
