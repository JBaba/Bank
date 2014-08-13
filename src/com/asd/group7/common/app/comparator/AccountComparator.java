/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.comparator;

import com.asd.group7.common.lib.account.AAccount;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author james
 */
public class AccountComparator implements Comparator<AAccount> {

    String fieldName;
    String methodName;

    public AccountComparator(String fieldName) throws Exception {
        boolean match = false;
        for (Field f : AAccount.class.getDeclaredFields()) {
            if (f.getName().equalsIgnoreCase(fieldName)) {
                match = true;
                this.fieldName = fieldName;
                this.methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            }
        }
        if (match == false) {
            throw new Exception();
        }
    }

    @Override
    public int compare(AAccount o1, AAccount o2) {
        String val1, val2;
        try {
            try {
                val1 = o1.getClass().getMethod(methodName, null).invoke(o1).toString();
                val2 = o1.getClass().getMethod(methodName, null).invoke(o2).toString();
                return (val1.compareTo(val2));
            } catch (IllegalAccessException ex) {
                Logger.getLogger(AccountComparator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(AccountComparator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(AccountComparator.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(AccountComparator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AccountComparator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
