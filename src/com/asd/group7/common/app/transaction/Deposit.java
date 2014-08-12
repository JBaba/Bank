/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.transaction;

import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.transaction.Credit;
import com.asd.group7.common.singleton.ClassicSingleton;

/**
 *
 * @author james
 */
public class Deposit extends Credit {
    
    public static final String DEPOSIT = "DEPOSIT";
    public static final String DEPOSIT_INTEREST = "INTEREST";

    private IAccount account;
    @Override
    public void compute() {
        this.setName(DEPOSIT);
        account.addBalance(this.getAmount());
        ClassicSingleton.getInstanceAccountManager().addTransactionToAccount(account, this);
    }

    @Override
    public void setAccount(IAccount account) {
        this.account = account;
    }

}
