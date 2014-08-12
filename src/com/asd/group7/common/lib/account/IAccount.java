/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.account;

import com.asd.group7.common.lib.functor.Functor;
import com.asd.group7.common.lib.functor.Predicate;
import com.asd.group7.common.lib.transaction.ITransaction;

/**
 *
 * @author james
 */
public interface IAccount {

    public void addEntry(ITransaction transaction);

    public double getCurrentBalance();

    public void notifyCustomer(Functor f, Predicate p);

    public String getType();

    public String getAccountNumber();

    public double getInterestAmount();
    
    public void updateAmountByTransaction(ITransaction transaction);

}
