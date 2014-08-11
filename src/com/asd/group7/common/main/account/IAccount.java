/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.main.account;

import com.asd.group7.common.main.functor.Functor;
import com.asd.group7.common.main.functor.Predicate;
import com.asd.group7.common.main.transaction.ITransaction;

/**
 *
 * @author james
 */
public interface IAccount {

    public void addEntry(ITransaction transaction);

    public double getCurrentBalance();

    public void notifyCustomer(Functor f, Predicate p);

    public String getType();
}
