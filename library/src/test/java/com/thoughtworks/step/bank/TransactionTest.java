package com.thoughtworks.step.bank;

import com.thoughtworks.step.bank.DebitTransaction;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {

    @Test
    public void must_create_debit_transaction_with_correct_date() {
        Date date = new Date();
        Transaction transaction = new DebitTransaction(date,2000,"another_account");
        assertThat(transaction.getDate(),is(date));
    }

    @Test
    public void must_create_credit_transaction_with_correct_date() {
        Date date = new Date();
        Transaction transaction = new CreditTransaction(date,2000,"another_account");
        assertThat(transaction.getDate(),is(date));
    }
}
