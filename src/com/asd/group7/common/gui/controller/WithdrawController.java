/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asd.group7.common.gui.controller;

import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.JDialog_Dialogview;
import com.asd.group7.common.lib.account.AccountManager;
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
    
    public void withdraw(String accrno,String amount){
    
    }
    
}
