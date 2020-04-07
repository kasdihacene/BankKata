package com.bankkata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankKataTest {

    int expectedAmount;
    int expectedNbTransactions;

    @Test
    public void init() {
        Assertions.assertThat(true).isTrue();
    }


    // Deposit amount of money and inject lambda function to get the amount inserted
    @Test
    public void deposit100DollarsIntoAccount() {

        int amount = 100;
        TransactionDouble transactionDouble = insertedAmount -> this.expectedAmount = insertedAmount;

        Account account = new AccountImplem(transactionDouble);
        account.deposit(amount);

        Assertions.assertThat(this.expectedAmount).isEqualTo(amount);
    }

    @Test
    public void withdraw100DollarsFromAccount() {
        int amount = 100;
        TransactionDouble transactionDouble = insertedAmount -> this.expectedAmount = insertedAmount;

        Account account = new AccountImplem(transactionDouble);
        account.withdraw(amount);

        Assertions.assertThat(this.expectedAmount).isEqualTo(amount);
    }


    @Test
    public void deposit100AndWithdraw50ShouldPrintTwoStatements() {
        int actualNbTransactions = 2;

        TransactionCount transactionCount = () -> expectedNbTransactions++;
        Account account = new AccountImplem(transactionCount);

        account.deposit(100);
        account.withdraw(50);

        Assertions.assertThat(expectedNbTransactions).isEqualTo(actualNbTransactions);
    }


}
