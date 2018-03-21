package com.thoughtworks.step.bank;

public class Account {
    private final String acc_no;
    private int balance;

    public Account(String acc_no, int balance){
        this.acc_no = acc_no;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public Object getAccountno() {
        return acc_no;
    }
}
