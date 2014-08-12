/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.factory;

import com.asd.group7.common.app.transaction.Deposit;
import com.asd.group7.common.app.transaction.Withdraw;
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
public class TransactionFactory extends AbstractFactory {

    @Override
    public IParty getParty(Enum type) {
        return null;
    }

    @Override
    public IAccount getAccount(Enum type) {
        return null;
    }

    @Override
    public ITransaction getTransaction(Enum type) {
        if (type == TransactionType.DEPOSIT) {
            return new Deposit();
        } else if (type == TransactionType.WITHDRAW) {
            return new Withdraw();
        }
        return null;
    }
}
