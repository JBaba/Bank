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
public class NewBalanceFunctor implements IFunctor<IParty> {

    @Override
    public void compute(IParty p) {
        System.out.println("Email: Your new balance is" + p.getBalance());
    }
}
