/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.transaction;

import com.asd.group7.common.lib.account.IAccount;
import java.util.Date;

/**
 *
 * @author james
 */
public abstract class ATransaction implements ITransaction {

    private double amount;
    private String name;
    private Date date;
    private IAccount account;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "ATransaction{" + "amount=" + amount + ", name=" + name + ", date=" + date + '}';
    }

    @Override
    public IAccount getAccount() {
        return account;
    }

    @Override
    public void setAccount(IAccount account) {
        this.account = account;
    }

}
