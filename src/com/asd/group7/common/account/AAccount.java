/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.account;

import com.asd.group7.common.transaction.ITransaction;
import java.util.List;

/**
 *
 * @author james
 */
public class AAccount {

    private String acctNumber;
    private List<ITransaction> transactions;
    private String type;
    private double balance;
}