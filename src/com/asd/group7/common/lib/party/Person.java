/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.party;

import com.asd.group7.common.app.predicates.Person500DepositPredicate;
import com.asd.group7.common.app.functors.PersonSendEmailFunctor;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.functor.IFunctor;
import com.asd.group7.common.lib.predicate.IPredicate;
import java.util.Date;

/**
 *
 * @author james
 */
public class Person extends AParty implements IPerson {

    private Date dateOfBirth;
    private final String type = "P";
    
    private IPredicate DepositMoreThan500Predicate;
    private IFunctor functor;

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public void addAccount(IAccount account) {
        super.addAccount(account);
    }

    @Override
    public void removeAccount(IAccount account) {
        //super.removeAccount(account);
    }

    @Override
    public void sendEmail(double amount) {
        this.DepositMoreThan500Predicate = new Person500DepositPredicate();
        this.functor = new PersonSendEmailFunctor();
        
        if(DepositMoreThan500Predicate.check(amount))
            functor.compute();
        
    }

    @Override
    public String getType() {
        return type;
    }


}
