/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.main.factory;

import com.asd.group7.common.main.account.DefaultAccount;
import com.asd.group7.common.main.account.IAccount;

/**
 *
 * @author james
 */
public class AccountFactory extends AAccountFactory {

    @Override
    public IAccount createAccount() {
        return new DefaultAccount();
    }
}
