/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.factory;

import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.party.IParty;
import com.asd.group7.common.lib.transaction.ITransaction;

/**
 *
 * @author james
 */
public abstract class AbstractFactory {

    public abstract IParty getParty(Enum type);

    public abstract IAccount getAccount(Enum type);

    public abstract ITransaction getTransaction(Enum type);
}
