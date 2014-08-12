/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.account;

import com.asd.group7.common.lib.transaction.ITransaction;
import java.util.List;

/**
 *
 * @author james
 */
public abstract class AAccount implements IAccount {

    private String acctNumber;
    private List<ITransaction> transactions;
    private String type;
    private double balance;

    public String getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(String acctNumber) {
        this.acctNumber = acctNumber;
    }

    public List<ITransaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<ITransaction> transactions) {
        this.transactions = transactions;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}