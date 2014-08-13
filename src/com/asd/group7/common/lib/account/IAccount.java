/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.account;

import com.asd.group7.common.lib.party.IParty;
import com.asd.group7.common.lib.transaction.ITransaction;

/**
 *
 * @author james
 */
public interface IAccount {

    public void addEntry(ITransaction transaction);

    public double getCurrentBalance();

    public String getType();

    public double getInterestAmount();

    public void updateAmountByTransaction(ITransaction transaction);

    public void setParty(IParty iParty);

    public String getAcctNumber();

    public IParty getParty();

    public StringBuilder generateReport();
}
