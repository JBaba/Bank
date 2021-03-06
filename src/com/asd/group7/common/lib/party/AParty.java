/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.party;

import com.asd.group7.common.lib.account.IAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author james
 */
public abstract class AParty implements IParty {

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;
    private List<IAccount> accountList;

    public AParty() {
        accountList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<IAccount> getAccountList() {
        return accountList;
    }

    @Override
    public void addAccount(IAccount account) {
        this.accountList.add(account);
        account.setParty(this);
    }

    public double getBalance() {
        double balance = 0;
        for (IAccount account : this.getAccountList()) {
            balance += account.getCurrentBalance();
        }
        return balance;
    }

    @Override
    public String toString() {
        return "AParty{" + "name=" + name + ", street=" + street + ", city=" + city + ", state=" + state + ", zip=" + zip + ", email=" + email + '}';
    }

}
