/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asd.group7.common.lib;

import com.asd.group7.common.app.iterator.SortedIterator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author james
 */
public class ASDArrayList extends ArrayList {

    public Iterator getSortedIterator(Comparator comparator) {
        return new SortedIterator(this, comparator);
    }
}
