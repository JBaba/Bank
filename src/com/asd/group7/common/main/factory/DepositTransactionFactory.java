/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.main.factory;

import com.asd.group7.common.main.transaction.Deposit;
import com.asd.group7.common.main.transaction.ITransaction;

/**
 *
 * @author james
 */
public class DepositTransactionFactory extends ATransactionFactory {

    @Override
    public ITransaction createTransaction() {
        return new Deposit();
    }
}
