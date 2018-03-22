package com.thoughtworks.step.bank;

import com.thoughtworks.step.bank.DebitTransaction;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
    @Test
    public void must_crete_debit_transaction() {
        Date date = new Date();
        DebitTransaction transaction = new DebitTransaction(date,2000,"another_account");
        assertThat(transaction.getDate(),is(date));
    }
}
