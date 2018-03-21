package com.thoughtworks.step.bank;

public class Account {
    private final String acc_no;
    private int balance;

    public Account(String acc_no, int balance) throws MinimumBalanceException{
        this.acc_no = acc_no;
        if (balance<500){
            throw new MinimumBalanceException();
        }
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public String getAccountno() {
        return acc_no;
    }
}
