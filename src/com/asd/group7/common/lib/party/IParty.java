/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.party;

import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.functor.IFunctor;
import com.asd.group7.common.lib.predicate.IPredicate;

/**
 *
 * @author james
 */
public interface IParty {

    public void addAccount(IAccount account);

    public void removeAccount(IAccount account);

    public void sendEmail(IFunctor f, IPredicate p, double amount);

    public String getType();
    
    public String getName();

    public void setName(String name);
    
    public IPredicate getDepositPredicate();
    
    public IPredicate getWithdrawPredicate();
    
    public double getBalance();
}
