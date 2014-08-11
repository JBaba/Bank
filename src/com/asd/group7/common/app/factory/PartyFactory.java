/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.factory;

import com.asd.group7.common.app.type.AccountType;
import com.asd.group7.common.app.type.PartyType;
import com.asd.group7.common.app.type.TransactionType;
import com.asd.group7.common.lib.factory.AbstractFactory;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.party.Company;
import com.asd.group7.common.lib.party.IParty;
import com.asd.group7.common.lib.party.Person;
import com.asd.group7.common.lib.transaction.ITransaction;

/**
 *
 * @author james
 */
public class PartyFactory extends AbstractFactory {

    @Override
    public IParty getParty(PartyType type) {
        if (type == PartyType.COMPANY) {
            return new Company();
        } else if (type == PartyType.PERSONAL) {
            return new Person();
        }
        return null;
    }

    @Override
    public IAccount getAccount(AccountType type) {
        return null;
    }

    @Override
    public ITransaction getTransaction(TransactionType type) {
        return null;
    }
}
