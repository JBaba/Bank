/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.asd.group7.common.app.functors;

import com.asd.group7.common.lib.functor.IFunctor;
import com.asd.group7.common.lib.party.IParty;

/**
 *
 * @author dhruba
 */
public class CompanyEmailSendFunctor implements IFunctor{

    private IParty p;
    public void setParty(IParty p){
        this.p = p;
    }
            
    @Override
    public void compute() {
       System.out.println("Email send to Company : "+ p.getName());
    }
    
    
}
