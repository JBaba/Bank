/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.party;

import com.asd.group7.common.lib.account.IAccount;
import com.asd.group7.common.lib.functor.IFunctor;
import com.asd.group7.common.lib.predicate.IPredicate;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author james
 */
public class Company extends AParty implements ICompany {

    private int noOfEmployee;
    private final String type = "C";
    private List<Person> personList;
    private IPredicate predicate;
    private IFunctor functor;

    public int getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(int noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void addPersonToList(Person person) {
        this.personList.add(person);
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
    public void sendEmail(double amount) {
        if(predicate!=null) {
            if(predicate.check(amount))
                functor.compute();
        }
        else
            functor.compute();
    }

    @Override
    public String getType() {
        return type;
    }
    
    public void setPredicate(IPredicate p){
        
        this.predicate = p;
    }
    public void setFunctor(IFunctor f){
        this.functor = f;
    }

}
