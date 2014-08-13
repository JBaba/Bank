/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.gui.controller;

import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.gui.JDialog_AddAccount;
import com.asd.group7.common.lib.account.AccountManager;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.awt.event.ActionEvent;

/**
 *
 * @author naimi_000
 */
public class AccountController implements Controller {

    private AccountManager accountManager = null;

    public AccountController() {
        accountManager = ClassicSingleton.getInstanceAccountManager();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //get Singlton variable and pass to dailog
        AccountFrm accountFrm = ClassicSingleton.getInstanceAccountFrm();
        JDialog_AddAccount pac = new JDialog_AddAccount(accountFrm);
        pac.setBounds(450, 20, 300, 330);
        pac.show();

    }

}
