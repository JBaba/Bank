/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.transaction;

import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.transaction.Debit;
import com.asd.group7.common.singleton.ClassicSingleton;

/**
 *
 * @author james
 */
public class Withdraw extends Debit {

    private IAccount account;
    @Override
    public void compute() {
        this.setName("Withdraw");
        account.deductBalance(this.getAmount());  
        account.addEntry(this);
        ClassicSingleton.getInstanceAccountManager().addTransactionToAccount(account, this);        
    }

    @Override
    public void setAccount(IAccount account) {
        this.account = account;      
    }
    
}
