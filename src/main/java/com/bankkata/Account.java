package com.bankkata;

public interface Account {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
