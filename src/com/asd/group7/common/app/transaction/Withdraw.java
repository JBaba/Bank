/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.transaction;

import com.asd.group7.common.app.functors.NegativeBalanceFunctor;
import com.asd.group7.common.lib.account.AccountManager;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.functor.IFunctor;
import com.asd.group7.common.lib.transaction.Debit;

/**
 *
 * @author james
 */
public class Withdraw extends Debit {

    public static final String WITHDRAW = "WITHDRAW";

    private AccountManager accountManager;
    private IAccount account;

    @Override
    public void compute() {
        accountManager.addTransactionToAccount(account, this);
    }

    public void setupTransaction(AccountManager accountManager, IAccount account) {
        this.accountManager = accountManager;
        this.account = account;
    }
    
    public IFunctor getDepositFunctor(){
        return null;
    }

    @Override
    public IFunctor getWithdrawFunctor() {
        return new NegativeBalanceFunctor();
    }
}
