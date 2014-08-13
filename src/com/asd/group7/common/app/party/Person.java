/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.party;

import com.asd.group7.common.app.predicates.NegativeBalancePredicate;
import com.asd.group7.common.app.predicates.Person500DepositPredicate;
import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.functor.IFunctor;
import com.asd.group7.common.lib.party.AParty;
import com.asd.group7.common.lib.party.IPerson;
import com.asd.group7.common.lib.predicate.IPredicate;
import java.util.Date;

/**
 *
 * @author james
 */
public class Person extends AParty implements IPerson {

    private Date dateOfBirth=new Date("08/08/2012");
    private final String type = "P";

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
    public void sendEmail(IFunctor f, IPredicate p, double amount) {
        if (p != null) {
            if (p.check(amount)) {
                if (f != null) {
                    f.compute(this);
                }
            }
        } else {
            f.compute(this);
        }
    }

    @Override
    public String getType() {
        return type;
    }

    public IPredicate getDepositPredicate() {
        return new Person500DepositPredicate();
    }

    public IPredicate getWithdrawPredicate() {
        return new NegativeBalancePredicate();
    }
}
