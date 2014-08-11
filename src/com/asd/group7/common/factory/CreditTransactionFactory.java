/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asd.group7.common.factory;

import com.asd.group7.common.account.IAccount;
import com.asd.group7.common.party.IParty;
import com.asd.group7.common.transaction.ITransaction;

/**
 *
 * @author james
 */
public class CreditTransactionFactory extends ATransactionFactory {

    @Override
    public ITransaction createTransaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IParty createParty() {
        return null;
    }

    @Override
    public IAccount createAccount() {
        return null;
    }
    
}
