package com.bankkata;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankKataTest {

    int expectedAmount;

    @Test
    public void init() {
        Assertions.assertThat(true).isTrue();
    }


    // Deposit amount of money and inject lambda function to get the amount inserted
    @Test
    public void deposit100DollarsIntoAccount() {

        int amount = 100;
        TransactionDouble transactionDouble = insertedAmount -> this.expectedAmount = insertedAmount ;

        Account account = new AccountImplem(transactionDouble);
        account.deposit(amount);

        Assertions.assertThat(this.expectedAmount).isEqualTo(amount);
    }

}
