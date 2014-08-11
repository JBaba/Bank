/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.main.transaction;

import com.asd.group7.common.main.account.IAccount;

/**
 *
 * @author james
 */
public interface ITransaction {

    public void compute();

    public void addAccount(IAccount account);
}
