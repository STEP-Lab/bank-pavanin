package com.thoughtworks.step.bank;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
    private Transactions transactions;
    @Before
    public void setUp(){
        transactions = new Transactions();
    }

    @Test
    public void credit_transaction() {
        transactions.credit(1000,"another_account");
        assertThat(transactions.transactionsRecord,hasItem(new CreditTransaction(1000,"another_account")));
    }

    @Test
    public void debit_transaction() {
        transactions.debit(1000,"another_account");
        assertThat(transactions.transactionsRecord,hasItem(new DebitTransaction(1000,"another_account")));
    }

    @Test
    public void debit_and_credit_transaction() {
        transactions.credit(1000,"another_account");
        transactions.debit(300,"another_account");
        assertThat(transactions.transactionsRecord,hasItems(new CreditTransaction(1000,"another_account"),new DebitTransaction(300,"another_account")));
    }
}
