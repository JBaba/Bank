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
import java.util.HashMap;

/**
 *
 * @author james
 */
public class FactoryProducer {

    public static HashMap<Enum,AbstractFactory> hashMap=new HashMap<>();

    static {
        hashMap.put(Types.PARTY, new PartyFactory());
        hashMap.put(Types.ACCOUNT, new AccountFactory());
        hashMap.put(Types.TRANSACTION, new TransactionFactory());
    }
    
    public FactoryProducer() {
//        hashMap.put(Types.PARTY, new PartyFactory());
//        hashMap.put(Types.ACCOUNT, new AccountFactory());
//        hashMap.put(Types.TRANSACTION, new TransactionFactory());
    }
    
    public static AbstractFactory getFactory(Enum type) {
        return hashMap.get(type);
    }
    
    public static void addAbstractFactory(Enum e,AbstractFactory factory){
        hashMap.put(e, factory);
    }
}
