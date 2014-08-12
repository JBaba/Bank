/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.account;

import com.asd.group7.common.lib.party.IParty;
import com.asd.group7.common.lib.transaction.ITransaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class AccountManager {

    private List<IAccount> accountList = new ArrayList<IAccount>();

    public void addInterest() {

    }

    public void createAccount(IParty party) {

    }

    public void removeAccount(IAccount account) {

    }
    
    public void addTransactionToAccount(IAccount account, ITransaction transaction) {
        account.addEntry(transaction);
        // TODO: update colleagues
    }
}
