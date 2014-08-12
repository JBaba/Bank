/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.transaction;

import com.asd.group7.common.app.type.TransactionType;
import com.asd.group7.common.app.type.Types;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.factory.FactoryProducer;
import com.asd.group7.common.lib.transaction.Credit;
import com.asd.group7.common.lib.transaction.ITransaction;

/**
 *
 * @author james
 */
public class Deposit extends Credit {

    private IAccount account;

    public IAccount getAccount() {
        return account;
    }

    public void setAccount(IAccount account) {
        this.account = account;
    }

    @Override
    public void compute() {
        ITransaction deposit = FactoryProducer.getFactory(Types.TRANSACTION).getTransaction(TransactionType.DEPOSIT);
        
        account.addEntry(deposit);
    }

    @Override
    public void addAccount(IAccount account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
