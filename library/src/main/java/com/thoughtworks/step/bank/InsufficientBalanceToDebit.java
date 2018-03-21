package com.thoughtworks.step.bank;

public class InsufficientBalanceToDebit extends Throwable {
    public InsufficientBalanceToDebit() {
        super("Don't have enough balance to debit");
    }
}
