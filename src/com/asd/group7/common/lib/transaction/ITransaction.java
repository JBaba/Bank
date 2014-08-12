/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.transaction;

import com.asd.group7.common.lib.account.IAccount;

/**
 *
 * @author james
 */
public interface ITransaction {

    public void compute();

    public void setAccount(IAccount account);

    public void setAmount(double amount);

    public void setName(String name);
}
