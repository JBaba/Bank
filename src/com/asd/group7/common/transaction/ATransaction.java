/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.transaction;

import java.util.Date;

/**
 *
 * @author james
 */
public abstract class ATransaction implements ITransaction {

    private double amount;
    private String name;
    private Date date;
}
