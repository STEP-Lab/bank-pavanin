package com.thoughtworks.step.bank;

public class Account {
    private final String acc_no;
    private double balance;

    public Account(String acc_no, int balance) throws MinimumBalanceException, InvalidAccountNumber {
        if (!acc_no.matches("[0-9]{4}(-)[0-9]{4}")){
            throw new InvalidAccountNumber();
        }
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

    public double credit(double amount) throws InvalidAmount {
        if(amount<0){
            throw new InvalidAmount("Amount should be more than 0");
        }
        this.balance+=amount;
        return this.balance;

    }

    public double debit(double amount) throws InvalidAmount {
        if(this.balance-amount<500){
            throw new InvalidAmount("Insufficient balance to debit");
        }
        this.balance-=amount;
        return this.balance;
    }
}
