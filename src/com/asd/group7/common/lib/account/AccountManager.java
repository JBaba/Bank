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
import com.asd.group7.common.lib.transaction.ITransaction;
import com.asd.group7.common.lib.transaction.TransactionManager;
import com.asd.group7.common.singleton.ClassicSingleton;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author james
 */
public class AccountManager {

    private List<IAccount> accountList = new ArrayList<IAccount>();
    private TransactionManager transactionManager = null;

    public AccountManager() {
        transactionManager = ClassicSingleton.getInstanceTransactionManager();
    }

    public void addInterest() {
        for (IAccount account : this.getAccountList()) {
            double interestAmount = account.getInterestAmount();
            ITransaction deposit = FactoryProducer.getFactory(Types.TRANSACTION).getTransaction(TransactionType.DEPOSIT);
            deposit.setAccount(account);
            deposit.setName(Deposit.DEPOSIT_INTEREST);
            deposit.setAmount(interestAmount);
            transactionManager.execute(deposit);
        }
    }

    public void removeAccount(IAccount account) {
        this.getAccountList().remove(account);
    }

    public List<IAccount> getAccountList() {
        return accountList;
    }

    public void addAccountToList(IAccount account) {
        this.accountList.add(account);
    }

    public void addTransactionToAccount(IAccount account, ITransaction transaction) {
        account.addEntry(transaction);
        account.updateAmountByTransaction(transaction);
        // TODO: update colleagues
    }

    public IAccount getAccountById(String accountId) {
        for (Iterator<IAccount> it = accountList.iterator(); it.hasNext();) {
            IAccount iAccount = it.next();
            if (iAccount.getAccountNumber().equalsIgnoreCase(accountId)) {
                return iAccount;
            }
        }
        return null;
    }

    public void addDeposit(IAccount account, ITransaction transaction) {
        performTransaction(account, transaction);
    }

    public void addWithdraw(IAccount account, ITransaction transaction) {
        performTransaction(account, transaction);
    }

    public void performTransaction(IAccount account, ITransaction transaction) {
        transactionManager.execute(transaction);
    }
}
