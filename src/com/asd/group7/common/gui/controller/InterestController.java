/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.gui.controller;

import com.asd.group7.common.lib.account.AccountManager;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author naimi_000
 */
public class InterestController implements Controller {

    private AccountManager accountManager = null;

    public InterestController() {
        accountManager = ClassicSingleton.getInstanceAccountManager();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        accountManager.addInterest();
        JOptionPane.showMessageDialog(ClassicSingleton.getInstanceAccountFrm(), "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
    }

}
