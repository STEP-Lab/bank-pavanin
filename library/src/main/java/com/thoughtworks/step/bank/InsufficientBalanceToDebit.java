package com.thoughtworks.step.bank;

public class InsufficientBalanceToDebit extends Throwable {
    public InsufficientBalanceToDebit(){
        super("Insufficent balance to debite");
    }
}
