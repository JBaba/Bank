/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib;

import com.asd.group7.common.app.iterator.SortedIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author james
 */
public class ASDArrayList<T> extends ArrayList {
    
    public ASDArrayList() {
        super();
    }

    public Iterator getSortedIterator(Comparator comparator) {
        return new SortedIterator(this, comparator);
    }

    
}
