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

    @Override
    public List subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator iterator() {
        return super.iterator(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator() {
        return super.listIterator(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator listIterator(int index) {
        return super.listIterator(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection c) {
        return super.retainAll(c); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection c) {
        return super.removeAll(c); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        super.removeRange(fromIndex, toIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return super.addAll(index, c); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection c) {
        return super.addAll(c); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        super.clear(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object remove(int index) {
        return super.remove(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, Object element) {
        super.add(index, element); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Object e) {
        return super.add(e); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object set(int index, Object element) {
        return super.set(index, element); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(int index) {
        return super.get(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray(Object[] a) {
        return super.toArray(a); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        return super.toArray(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object clone() {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        return super.lastIndexOf(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        return super.indexOf(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return super.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ensureCapacity(int minCapacity) {
        super.ensureCapacity(minCapacity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void trimToSize() {
        super.trimToSize(); //To change body of generated methods, choose Tools | Templates.
    }
}
