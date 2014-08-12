/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.factory;

import com.asd.group7.common.app.account.DefaultAccount;
import com.asd.group7.common.app.type.AccountType;
import com.asd.group7.common.app.type.PartyType;
import com.asd.group7.common.app.type.TransactionType;
import com.asd.group7.common.lib.factory.AbstractFactory;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.party.IParty;
import com.asd.group7.common.lib.transaction.ITransaction;

/**
 *
 * @author james
 */
public class AccountFactory extends AbstractFactory {

    @Override
    public IParty getParty(Enum type) {
        return null;
    }

    @Override
    public IAccount getAccount(Enum type) {
        if (type == AccountType.DEFAULT_ACCOUNT) {
            return new DefaultAccount();
        }
        return null;
    }

    @Override
    public ITransaction getTransaction(Enum type) {
        return null;
    }
}
