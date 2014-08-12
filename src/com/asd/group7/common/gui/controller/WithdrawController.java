/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asd.group7.common.gui.controller;

import com.asd.group7.common.app.type.TransactionType;
import com.asd.group7.common.app.type.Types;
import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.JDialog_Dialogview;
import com.asd.group7.common.lib.account.AccountManager;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.factory.FactoryProducer;
import com.asd.group7.common.lib.transaction.ITransaction;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.awt.event.ActionEvent;

/**
 *
 * @author naimi_000
 */
public class WithdrawController implements Controller{

    private AccountManager accountManager=null;
    
    public WithdrawController() {
        accountManager=ClassicSingleton.getInstanceAccountManager();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        AccountFrm accountFrm = ClassicSingleton.getInstanceAccountFrm();
        String accnr = accountFrm.getAccountNo();
        JDialog_Dialogview dep = new JDialog_Dialogview(accountFrm, accnr);
        dep.setBounds(430, 15, 275, 140);
        dep.show();
    }
    
    public WithdrawController(String accrno,String amount){
        this();
    }
    
    public void withdraw(String accrno,String amount,String name){
        try{
            IAccount account=accountManager.getAccountById(accrno);
            ITransaction iTransaction=FactoryProducer.getFactory(Types.TRANSACTION).getTransaction(TransactionType.WITHDRAW);
            iTransaction.setAmount(Double.parseDouble(amount));
            iTransaction.setName(name);
            accountManager.Withdraw(account, iTransaction);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
