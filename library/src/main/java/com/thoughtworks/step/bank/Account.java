package com.thoughtworks.step.bank;

public class Account {
    private double balance;
    private AccountNumber accountNumber;
    private double minimumBalance = 500;

    public Account(AccountNumber accountNumber, int balance) throws MinimumBalanceException{
        validateMinimumBalance(balance);
        this.balance = balance;
    }

    private void validateMinimumBalance(double amount) throws MinimumBalanceException {
        if(amount<this.minimumBalance){
            throw new MinimumBalanceException();
        }
    }

    public double getBalance() {
        return balance;
    }

    public double credit(double amount) throws InvalidAmount {
        if(amount<0){
            throw new InvalidAmount("Amount should be more than 0");
        }
        this.balance+=amount;
        return this.balance;
    }

    public double debit(double amount) throws MinimumBalanceException {
       validateMinimumBalance(this.balance-amount);
        this.balance-=amount;
        return this.balance;
    }
}
