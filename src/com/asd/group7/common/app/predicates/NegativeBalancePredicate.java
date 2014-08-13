/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.predicates;

import com.asd.group7.common.lib.predicate.IPredicate;

/**
 *
 * @author dhruba
 */
public class NegativeBalancePredicate implements IPredicate<Double> {

    @Override
    public boolean check(Double t) {
        return t < 0;
    }
}
