package com.thoughtworks.step.bank;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;

public class Transactions {
    ArrayList<Transaction> list;

    public Transactions() {
        this.list = new ArrayList<>();
    }

    public void credit(double amount, String from) {
        Date date = new Date();
        this.list.add(new CreditTransaction(amount,from));
    }

    public void debit(double amount, String to) {
        Date date = new Date();
        this.list.add(new DebitTransaction(amount,to));
    }

    public Transactions filterByAmountGreaterThan(double amount) {
        Transactions transactions = new Transactions();
        for(Transaction transaction: list){
            if(transaction.getAmount()>=amount){
                transactions.list.add(transaction);
            }
        }
        return transactions;
    }

    public void print(PrintWriter printWriter) {
        for (Transaction transaction:list){
            printWriter.println(transaction.toString());
        }
    }
}
