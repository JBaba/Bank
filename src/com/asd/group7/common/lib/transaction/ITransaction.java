/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.transaction;

import com.asd.group7.common.lib.account.AccountManager;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.functor.IFunctor;

/**
 *
 * @author james
 */
public interface ITransaction {

    public void compute();

    public void setAccount(IAccount account);

    public IAccount getAccount();

    public void setAmount(double amount);

    public double getAmount();

    public void setName(String name);

    public double getSignedAmount();

    public void setupTransaction(AccountManager accountManager, IAccount account);

    public IFunctor getDepositFunctor();

    public IFunctor getWithdrawFunctor();
}
