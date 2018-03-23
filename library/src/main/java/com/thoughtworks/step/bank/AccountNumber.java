package com.thoughtworks.step.bank;

public class AccountNumber {

    private String account_number;

    public AccountNumber(String number) throws InvalidAccountNumber {
        validateAccountNumber(number);
    }

    private void validateAccountNumber(String number) throws InvalidAccountNumber {
        if (!number.matches("[0-9]{4}(-)[0-9]{4}")){
            throw new InvalidAccountNumber();
        }
        this.account_number=number;
    }
}
