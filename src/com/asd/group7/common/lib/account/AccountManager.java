/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.account;

import com.asd.group7.common.app.transaction.Deposit;
import com.asd.group7.common.app.type.TransactionType;
import com.asd.group7.common.app.type.Types;
import com.asd.group7.common.lib.factory.FactoryProducer;
import com.asd.group7.common.lib.functor.IFunctor;
import com.asd.group7.common.lib.mediator.ISenderColleague;
import com.asd.group7.common.lib.mediator.Mediator;
import com.asd.group7.common.lib.mediator.Message;
import com.asd.group7.common.lib.predicate.IPredicate;
import com.asd.group7.common.lib.transaction.ITransaction;
import com.asd.group7.common.lib.transaction.TransactionManager;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.sql.rowset.Predicate;

/**
 *
 * @author james
 */
public class AccountManager implements ISenderColleague {

    private static final String NAME = "ACCOUNT_MANAGER";
    public static final String ACCOUNT_SELECTED = "ACCOUNT_SELECTED";
    public static final String ACCOUNT_LIST_NOT_EMPTY = "ACCOUNT_LIST_NOT_EMPTY";
    public static final String UPDATE_ACCOUNT_TABLE = "UPDATE_ACCOUNT_TABLE";
    
    private List<IAccount> accountList = new ArrayList<IAccount>();
    private TransactionManager transactionManager = null;
    private Mediator mediator;

    public AccountManager(Mediator mediator) {
        transactionManager = ClassicSingleton.getInstanceTransactionManager();
        this.mediator = mediator;
        this.send(new Message(ACCOUNT_LIST_NOT_EMPTY, false));
        this.send(new Message(ACCOUNT_SELECTED, false));
    }

    public void addInterest() {
        for (IAccount account : this.getAccountList()) {
            double interestAmount = account.getInterestAmount();
            ITransaction deposit = FactoryProducer.getFactory(Types.TRANSACTION).getTransaction(TransactionType.DEPOSIT);
            deposit.setupTransaction(this, account);
            deposit.setName(Deposit.DEPOSIT_INTEREST);
            deposit.setAmount(interestAmount);
            transactionManager.execute(deposit);
        }
        this.updateAccountTable();
    }

    public void removeAccount(IAccount account) {
        this.getAccountList().remove(account);
        this.send(new Message(ACCOUNT_LIST_NOT_EMPTY, this.getAccountList().size()>0));
        this.updateAccountTable();
    }

    public List<IAccount> getAccountList() {
        return accountList;
    }

    public void addAccountToList(IAccount account) {
        this.accountList.add(account);
        this.send(new Message(ACCOUNT_LIST_NOT_EMPTY, true));
        this.updateAccountTable();
    }

    /*This transaction is called from command Class, 
    This records transaction and performs necessary actions on account */
    public void addTransactionToAccount(IAccount account, ITransaction transaction) {
        account.addEntry(transaction);
        account.updateAmountByTransaction(transaction);
        
        IPredicate p;
        IFunctor f;
        
        if(transaction instanceof Deposit) {
            p = account.getParty().getDepositPredicate();
            f = transaction.getDepositFunctor();
        } else {
            p = account.getParty().getWithdrawPredicate();
            f = transaction.getWithdrawFunctor();
        }
        
        account.getParty().sendEmail(f, p, account.getCurrentBalance());
        this.updateAccountTable();
    }

    public IAccount getAccountById(String accountId) {
        for (Iterator<IAccount> it = accountList.iterator(); it.hasNext();) {
            IAccount iAccount = it.next();
            if (iAccount.getAcctNumber().equalsIgnoreCase(accountId)) {
                return iAccount;
            }
        }
        return null;
    }
    
    /*
    Controllers will call Deposit to deposit amount through transaction
    */
    public void Deposit(IAccount account, ITransaction transaction) {
        performTransaction(account, transaction);
    }

    
    /*
    Controllers will call Withdraw to withdraw amount through transaction
    */
    public void Withdraw(IAccount account, ITransaction transaction) {
        performTransaction(account, transaction);
    }

    /*
    Pass transaction to command to execute. 
    This will perform transaction by command pattern
    */
    public void performTransaction(IAccount account, ITransaction transaction) {
        transaction.setupTransaction(this, account);
        transactionManager.execute(transaction);
    }

    @Override
    public void send(Message message) {
        mediator.send(this, new Message(message.getAbout(), message.isStatus()));
    }

    @Override
    public String getName() {
        return NAME;
    }
    
    public void updateAccountTable() {
        this.send(new Message(UPDATE_ACCOUNT_TABLE, true));
    }
    
    public StringBuilder generateReport() {
        StringBuilder myBuilder=new StringBuilder();
        for (Iterator<IAccount> it = accountList.iterator(); it.hasNext();) {
            IAccount iAccount = it.next();
            myBuilder.append("\n"+iAccount.generateReport().toString());
        }
        return myBuilder;
    }
}
