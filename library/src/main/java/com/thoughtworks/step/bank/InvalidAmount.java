package com.thoughtworks.step.bank;

public class InvalidAmount extends Throwable {
    public InvalidAmount(String message) {
        super(message);
    }
}
