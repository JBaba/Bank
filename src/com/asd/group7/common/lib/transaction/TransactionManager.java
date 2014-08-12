/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.transaction;

import com.asd.group7.common.lib.mediator.ISenderColleague;
import com.asd.group7.common.lib.mediator.Mediator;
import com.asd.group7.common.lib.mediator.Message;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public class TransactionManager implements ISenderColleague {

    private static final String NAME = "TRANSACTION_MANAGER";
    Mediator mediator;
    private List<ITransaction> transactionList;

    public TransactionManager(Mediator mediator) {
        transactionList = new ArrayList<>();
        this.mediator = mediator;
    }
    
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void execute(ITransaction transaction) {
        transaction.compute();
        transactionList.add(transaction);
    }

    public List getListOfTransaction() {
        return this.transactionList;
    }

    @Override
    public void send(Message message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName() {
        return NAME;
    }
}
