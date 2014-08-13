/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.singleton;

import com.asd.group7.common.gui.AccountFrm;
import com.asd.group7.common.lib.account.AccountManager;
import com.asd.group7.common.lib.mediator.Mediator;
import com.asd.group7.common.lib.transaction.TransactionManager;

/**
 *
 * @author naimi_000
 */
public class ClassicSingleton {

    private static AccountFrm instance = null;
    private static AccountManager accountManager = null;
    private static TransactionManager transactionManager = null;
    private static Mediator mediator = null;
    

    protected ClassicSingleton() {
        // Exists only to defeat instantiation.
    }
    
    public static void setAccountFrm(AccountFrm accountFrm) {
        instance = accountFrm;
    }

    public static AccountFrm getInstanceAccountFrm() {
        if (instance == null) {
            instance = new AccountFrm();
        }
        return instance;
    }

    public static AccountManager getInstanceAccountManager() {
        if (accountManager == null) {
            accountManager = new AccountManager(getMediator());
        }
        return accountManager;
    }

    public static TransactionManager getInstanceTransactionManager() {
        if (transactionManager == null) {
            transactionManager = new TransactionManager(getMediator());
        }
        return transactionManager;
    }

    public static Mediator getMediator() {
        if (mediator == null) {
            mediator = new Mediator();
        }
        return mediator;
    }
}
