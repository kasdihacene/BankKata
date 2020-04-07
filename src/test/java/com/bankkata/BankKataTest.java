package com.bankkata;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BankKataTest {

    int expectedAmount;
    int expectedNbTransactions;
    private List<Transaction> transactionsToPrint;

    @Test
    public void init() {
        assertThat(true).isTrue();
    }


    // Deposit amount of money and inject lambda function to get the amount inserted
    @Test
    public void deposit100DollarsIntoAccount() {

        int amount = 100;
        TransactionDouble transactionDouble = insertedAmount -> this.expectedAmount = insertedAmount;

        Account account = new AccountImplem(transactionDouble);
        account.deposit(amount);

        assertThat(this.expectedAmount).isEqualTo(amount);
    }

    @Test
    public void withdraw100DollarsFromAccount() {
        int amount = 100;
        TransactionDouble transactionDouble = insertedAmount -> this.expectedAmount = insertedAmount;

        Account account = new AccountImplem(transactionDouble);
        account.withdraw(amount);

        assertThat(this.expectedAmount).isEqualTo(amount);
    }


    @Test
    public void deposit100AndWithdraw50ShouldPrintTwoStatements() {
        int actualNbTransactions = 2;

        TransactionCount transactionCount = () -> expectedNbTransactions++;
        Account account = new AccountImplem(transactionCount);

        account.deposit(100);
        account.withdraw(50);

        assertThat(expectedNbTransactions).isEqualTo(actualNbTransactions);
    }

    // we have to intercept every transaction and add it to list of transactions to print
    @Test
    public void deposit100AndWithdraw50ShouldPrintStatementsDepositAndWithdrawal() {
        Transaction transactionDeposit = new Transaction("06/02/2020", 200, TransactionType.DEPOSIT);
        Transaction transactionWithdrawal = new Transaction("06/02/2020", 100, TransactionType.WITHDRAWAL);
        List<Transaction> transactions = Arrays.asList(transactionDeposit, transactionWithdrawal);

        List<Transaction> addedTransactions = new ArrayList<>();
        TransactionAppender transactionAppender = addedTransactions::add;
        TransactionFetcher transactionFetcher = () -> addedTransactions;

        TransactionPrinter transactionPrinter = passedTransactions -> this.transactionsToPrint = passedTransactions;
        Account account = new AccountImplem(transactionAppender, transactionFetcher, transactionPrinter);

        account.deposit(200);
        account.withdraw(100);
        account.printStatement();

        assertThat(transactions.toString()).isEqualTo(transactionsToPrint.toString());

    }
}
