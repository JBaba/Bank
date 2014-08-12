/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.transaction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class TransactionManager {

    private List<ITransaction> transactionList;

    public TransactionManager() {
        transactionList=new ArrayList<>();
    }
    
    public void execute(ITransaction transaction) {       
        transaction.compute();
        transactionList.add(transaction);
    }
    
    public List getListOfTransaction()
    {return this.transactionList;}
}
