package com.thoughtworks.step.bank;

public class InvalidAccountNumber extends Throwable {
    public InvalidAccountNumber() {
        super("Invalid Account number (should be like 1111-1111)");
    }
}
