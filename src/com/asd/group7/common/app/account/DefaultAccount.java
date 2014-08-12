/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.account;

import com.asd.group7.common.lib.account.AAccount;

/**
 *
 * @author james
 */
public class DefaultAccount extends AAccount {

    @Override
    public String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getInterestAmount() {
        return 0;
    }
}
