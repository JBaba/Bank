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

    public static final String TYPE = "D";

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public double getInterestAmount() {
        return 0;
    }
}
