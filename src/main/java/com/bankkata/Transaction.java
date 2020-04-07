package com.bankkata;

public class Transaction {
    private final String s;
    private final int i;
    private final TransactionType deposit;

    public Transaction(String s, int i, TransactionType deposit) {

        this.s = s;
        this.i = i;
        this.deposit = deposit;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "s='" + s + '\'' +
                ", i=" + i +
                ", deposit=" + deposit +
                '}';
    }
}
