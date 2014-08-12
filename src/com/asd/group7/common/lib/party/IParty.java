/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.party;

import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.functor.Functor;
import com.asd.group7.common.lib.functor.Predicate;

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