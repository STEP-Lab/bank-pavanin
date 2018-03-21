package com.thoughtworks.step.bank;

public class Account {
    private final String acc_no;
    private double balance;

    public Account(String acc_no, int balance) throws MinimumBalanceException{
        this.acc_no = acc_no;
        if (balance<500){
            throw new MinimumBalanceException();
        }
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountno() {
        return acc_no;
    }

    public double credit(double amount) {
        this.balance+=amount;
        return this.balance;

    }

    public double debit(double amount) {
        this.balance-=amount;
        return this.balance;
    }
}
