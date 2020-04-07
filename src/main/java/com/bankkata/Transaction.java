package com.bankkata;

import java.util.Objects;

public class Transaction {
    private final String date;
    private final int amount;
    private final TransactionType transactionType;

    private Transaction(String date, int amount, TransactionType transactionType) {

        this.date = date;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", amount=" + amount +
                ", transactionType=" + transactionType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                Objects.equals(date, that.date) &&
                transactionType == that.transactionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, transactionType);
    }

    public static Builder instance() {
        return new Builder();
    }

    public static final class Builder {
        private String date;
        private int amount;
        private TransactionType transactionType;

        private Builder() {
        }

        public Builder withDate(String date) {
            this.date = date;
            return this;
        }

        public Builder withAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder withTransactionType(TransactionType transactionType) {
            this.transactionType = transactionType;
            return this;
        }

        public Transaction build() {
            return new Transaction(date, amount, transactionType);
        }
    }
}
