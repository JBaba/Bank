/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.main.party;

import com.asd.group7.common.main.account.IAccount;
import com.asd.group7.common.main.functor.Functor;
import com.asd.group7.common.main.functor.Predicate;

/**
 *
 * @author james
 */
public interface IParty {

    public void addAccount(IAccount account);

    public void removeAccount(IAccount account);

    public void sendEmail(Functor f, Predicate p);

    public String getType();
}
