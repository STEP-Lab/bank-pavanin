package com.thoughtworks.step.bank;

public class MinimumBalanceException extends Throwable {
    public MinimumBalanceException() {
        super("Insufficent balance minimum balance is '500'");
    }
}