package com.bankkata;

public class AccountImplem implements Account {
    private TransactionDouble transactionDouble;

    public AccountImplem(TransactionDouble transactionDouble) {
        this.transactionDouble = transactionDouble;
    }

    @Override
    public void deposit(int amount) {
        transactionDouble.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        transactionDouble.deposit(amount);

    }

    @Override
    public void printStatement() {

    }
}
