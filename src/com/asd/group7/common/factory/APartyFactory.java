/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.factory;

import com.asd.group7.common.party.IParty;

/**
 *
 * @author james
 */
public abstract class APartyFactory implements IFactory {

    public abstract IParty createParty();
}
