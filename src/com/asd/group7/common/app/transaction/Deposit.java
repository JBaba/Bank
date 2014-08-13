/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.transaction;

import com.asd.group7.common.app.functors.NewBalanceFunctor;
import com.asd.group7.common.lib.account.AccountManager;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.functor.IFunctor;
import com.asd.group7.common.lib.transaction.Credit;

/**
 *
 * @author james
 */
public class Deposit extends Credit {

    public static final String DEPOSIT = "DEPOSIT";
    public static final String DEPOSIT_INTEREST = "INTEREST";

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

    public IFunctor getDepositFunctor() {
        return new NewBalanceFunctor();
    }

    @Override
    public IFunctor getWithdrawFunctor() {
        return null;
    }
}
