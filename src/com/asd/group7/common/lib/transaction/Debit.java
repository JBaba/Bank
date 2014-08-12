/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.transaction;

/**
 *
 * @author james
 */
public abstract class Debit extends ATransaction {
    
    public double getSignedAmount() {
        return -1 * this.getAmount();
    }

}
