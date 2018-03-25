package com.thoughtworks.step.bank;

import java.util.ArrayList;
import java.util.Date;

public class Transactions {
    ArrayList<Transaction> transactionsRecord;

    public Transactions() {
        this.transactionsRecord = new ArrayList<>();
    }

    public void credit(double amount, String from) {
        Date date = new Date();
        this.transactionsRecord.add(new CreditTransaction(amount,from));
    }

    public void debit(double amount, String to) {
        Date date = new Date();
        this.transactionsRecord.add(new DebitTransaction(amount,to));
    }
}
