/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.app.iterator;

import com.asd.group7.common.lib.ASDArrayList;
import java.util.*;

/**
 *
 * @author james
 */
public class SortedIterator<T> implements Iterator<T> {

    private ListIterator<T> it;

    public SortedIterator(ASDArrayList list, Comparator comparator) {
        Collections.sort(list, comparator);
        this.it = list.listIterator();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public T next() {
        return it.next();
    }

    @Override
    public void remove() {
        it.remove();
    }

}
