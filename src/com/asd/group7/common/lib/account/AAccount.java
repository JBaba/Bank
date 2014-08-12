/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.account;

import com.asd.group7.common.lib.functor.Functor;
import com.asd.group7.common.lib.functor.Predicate;
import com.asd.group7.common.lib.party.IParty;
import com.asd.group7.common.lib.transaction.ITransaction;
import java.util.List;

/**
 *
 * @author james
 */
public abstract class AAccount implements IAccount {

    private String acctNumber;
    private List<ITransaction> transactions;
    private double balance;
    private IParty iParty;

    public String getAcctNumber() {
        return acctNumber;
    }

    public void setAcctNumber(String acctNumber) {
        this.acctNumber = acctNumber;
    }

    public List<ITransaction> getTransactions() {
        return transactions;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void addEntry(ITransaction transaction) {
        this.transactions.add(transaction);
    }

    @Override
    public double getCurrentBalance() {
        return this.balance;
    }

    @Override
    public void notifyCustomer(Functor f, Predicate p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAccountNumber() {
        return this.getAccountNumber();
    }
    
    public void updateAmountByTransaction(ITransaction transaction){
        this.balance += transaction.getSignedAmount();
    }

    @Override
    public IParty getParty() {
        return iParty;
    }

    @Override
    public void setParty(IParty iParty) {
        this.iParty=iParty;
    }

    
    
    
    
}
