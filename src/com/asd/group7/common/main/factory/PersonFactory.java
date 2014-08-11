/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.main.factory;

import com.asd.group7.common.main.party.IParty;
import com.asd.group7.common.main.party.Person;

/**
 *
 * @author james
 */
public class PersonFactory extends APartyFactory {

    @Override
    public IParty createParty() {
        return new Person();
    }
}
