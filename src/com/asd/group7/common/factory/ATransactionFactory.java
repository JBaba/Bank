/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.factory;

import com.asd.group7.common.transaction.ITransaction;

/**
 *
 * @author james
 */
public abstract class ATransactionFactory implements IFactory {

    public abstract ITransaction createTransaction();
}
