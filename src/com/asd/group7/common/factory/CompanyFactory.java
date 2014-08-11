/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.factory;

import com.asd.group7.common.party.Company;
import com.asd.group7.common.party.IParty;

/**
 *
 * @author james
 */
public class CompanyFactory extends APartyFactory {

    @Override
    public IParty createParty() {
        return new Company();
    }
}
