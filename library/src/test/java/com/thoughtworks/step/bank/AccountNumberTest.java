package com.thoughtworks.step.bank;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountNumberTest {
    @Test(expected = InvalidAccountNumber.class)
    public void check_acccont_number() throws InvalidAccountNumber {
        new AccountNumber("1234");
    }

    @Test (expected = InvalidAccountNumber.class)
    public void check_account_number_with_alphabets() throws InvalidAccountNumber {
        new AccountNumber("123a-23ab");
    }

    @Test
    public void check_valid_account_number() throws InvalidAccountNumber {
        new AccountNumber("1234-5678");
    }
}