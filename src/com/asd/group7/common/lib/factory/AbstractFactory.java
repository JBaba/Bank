/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.factory;

import com.asd.group7.common.app.type.AccountType;
import com.asd.group7.common.app.type.PartyType;
import com.asd.group7.common.app.type.TransactionType;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.party.IParty;
import com.asd.group7.common.lib.transaction.ITransaction;

/**
 *
 * @author james
 */
public abstract class AbstractFactory {

    public abstract IParty getParty(PartyType type);

    public abstract IAccount getAccount(AccountType type);

    public abstract ITransaction getTransaction(TransactionType type);
}
