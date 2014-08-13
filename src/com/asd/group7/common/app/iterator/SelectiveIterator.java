/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.iterator;

import com.asd.group7.common.lib.predicate.IPredicate;
import java.util.*;
import java.util.List;

/**
 *
 * @author dAdhikari
 */
public class SelectiveIterator<T> implements Iterator<T> {

    private ListIterator it;
    private IPredicate predicate;

    public SelectiveIterator(List list, IPredicate predicate) {
        this.it = list.listIterator();
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        while (it.hasNext()) {
            if (predicate.check(it.next()) == true) {
                it.previous();
                return true;
            }
        }
        return false;
    }

    @Override
    public T next() {
        while (it.hasNext()) {
            Object i = it.next();
            if (predicate.check(i) == true) {
                return (T) i;
            }

        }
        return null;

    }

    @Override
    public void remove() {
        it.remove();
    }

}
