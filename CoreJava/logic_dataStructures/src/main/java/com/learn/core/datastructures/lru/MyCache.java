/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.datastructures.lru;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 *
 * @author SanghviR
 */
public class MyCache {

    final private TreeMap<String, String> tm = new TreeMap<>();
    final private LinkedList<String> ll = new LinkedList<>();

    public static void main(String[] args) {
        MyCache cache = new MyCache();
        cache.addRecords("1", "Rahul");
        cache.addRecords("2", "Rakesh");
        cache.addRecords("3", "Shravan");
        
        System.out.println("Current records in tm is "+cache.tm);
        System.out.println("Current records in linkedlist "+cache.ll);
        
        System.out.println("Fetching record "+cache.getRecord("1"));
        System.out.println("Current records in linkedlist after reading a value "+cache.ll);
        cache.addRecords("4", "KK");
        
        System.out.println("Now the current records in linkedlist "+cache.ll);
        System.out.println("Now the current records in tm is "+cache.tm);
        
    }

    private void addRecords(String key, String value) {
        int size = tm.size();
        if (size >= 3) {
            //remove the least recently used key
            String lru = ll.getFirst();
            tm.remove(lru);
            ll.removeFirst();
        }
        tm.put(key, value);
        ll.add(key);
    }

    private String getRecord(String key) {
        String ret = tm.get(key);
        ll.remove(key);
        ll.addLast(key);
        return ret;
    }
}
