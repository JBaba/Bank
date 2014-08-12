/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib.factory;

import com.asd.group7.common.app.factory.AccountFactory;
import com.asd.group7.common.app.factory.PartyFactory;
import com.asd.group7.common.app.factory.TransactionFactory;
import com.asd.group7.common.app.type.Types;

/**
 *
 * @author james
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(Types type) {
        if (type == Types.PARTY) {
            return new PartyFactory();
        } else if (type == Types.ACCOUNT) {
            return new AccountFactory();
        } else if (type == Types.PARTY) {
            return new TransactionFactory();
        }
        return null;
    }
}
