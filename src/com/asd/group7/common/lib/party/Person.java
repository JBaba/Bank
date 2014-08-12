/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.party;

import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.functor.IFunctor;
import com.asd.group7.common.lib.functor.IPredicate;
import java.util.Date;

/**
 *
 * @author james
 */
public class Person extends AParty implements IPerson {

    private Date dateOfBirth;
    private final String type = "P";

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public void addAccount(IAccount account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAccount(IAccount account) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendEmail(IFunctor f, IPredicate p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getType() {
        return type;
    }
}
