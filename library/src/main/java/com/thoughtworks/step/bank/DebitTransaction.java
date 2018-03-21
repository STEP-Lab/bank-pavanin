package com.thoughtworks.step.bank;

import java.util.Date;

public class DebitTransaction {
    protected Date date;
    private final double amount;
    private final String to;

    public DebitTransaction(Date date,double amount, String to) {
        this.date = date;
        this.amount = amount;
        this.to = to;
    }

    public Date getDate() {
        return date;
    }
}
