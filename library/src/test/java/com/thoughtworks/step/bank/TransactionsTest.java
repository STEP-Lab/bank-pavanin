package com.thoughtworks.step.bank;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
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
        assertThat(transactions.list,hasItem(new CreditTransaction(1000,"another_account")));
    }

    @Test
    public void debit_transaction() {
        transactions.debit(1000,"another_account");
        assertThat(transactions.list,hasItem(new DebitTransaction(1000,"another_account")));
    }

    @Test
    public void debit_and_credit_transaction() {
        transactions.credit(1000,"another_account");
        transactions.debit(300,"another_account");
        assertThat(transactions.list,hasItems(new CreditTransaction(1000,"another_account"),new DebitTransaction(300,"another_account")));
    }

    @Test
    public void print_transactions() throws FileNotFoundException, UnsupportedEncodingException {
        CreditTransaction creditTransaction = new CreditTransaction(1000, "pavani");
        DebitTransaction debitTransaction = new DebitTransaction(1000, "bhavani");
        ArrayList<String> result= new ArrayList<>();
        this.transactions.credit(1000,"pavani");
        this.transactions.debit(1000,"bhavani");
        PrintWriter writer=new PrintWriter("file_name.txt","utf-8"){
            @Override
            public void println(String x) {
                result.add(x);
            }
        };

        this.transactions.print(writer);
        writer.close();
        assertThat(result,hasItems(creditTransaction.toString(),debitTransaction.toString()));
    }

    @Test
    public void filter_transaction_by_amount() {
        transactions.credit(1000,"pavani");
        transactions.credit(900,"ganga");
        transactions.credit(1500,"bhavani");
        Transactions filteredTransactions=transactions.filterByAmountGreaterThan(1000);
        assertThat(filteredTransactions.list,hasItems(new CreditTransaction(1000,"pavani"),new CreditTransaction(1500,"bhavani")));
    }
}
