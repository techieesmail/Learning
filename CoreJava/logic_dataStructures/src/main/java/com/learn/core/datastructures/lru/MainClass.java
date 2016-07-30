/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.datastructures.lru;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map.Entry;

/**
 *
 * @author sanghvir
 */
public class MainClass {
    
    public static void main(String[] args) {
        //collectionApproach();
        //lru datastructure is linkedlist with Queue FIFO.
        algo();
    }
    private static void algo(){
        
        //LRU can be obtained via Queue logic
        LinkedList<Integer> ll = new LinkedList<>();
        int i = 1;
        while(i <= 15){
            ll.add(i);
            i++;
        }
        System.out.println("The list after additions "+ll);
        
        //remove number 6 and hence index is -1
        ll.get(5);
        ll.remove(5);
        ll.addLast(6);
        
        
        ll.get(0);
        ll.remove(0);
        ll.addLast(1);
        
        System.out.println("The list after operations "+ll);
        System.out.println("The least recently used element is "+ll.getFirst());
        
    }
    
    private static void collectionApproach(){
        CustomLinkedHashMap map =  new CustomLinkedHashMap(10,1.1f,true);
        LinkedHashMap<Integer,Integer> hm = new LinkedHashMap<>(10, 1.1f, false);
        int i = 1;
        while(i <= 15){
            map.put(i, i);
            hm.put(i, i);
            i++;
        }
        hm.put(2,20);
        System.out.println("The map is "+map);
        System.out.println("The linked is "+hm);
        
        //accessing elements 
        map.get(10);
        map.get(8);
        
        System.out.println("The linked after accessing "+map);
    }
}

class CustomLinkedHashMap extends LinkedHashMap<Integer, Integer>{

    private int capacity;
    public CustomLinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
        this.capacity = initialCapacity;
        
    }
    
    
    @Override
    protected boolean removeEldestEntry(Entry<Integer, Integer> eldest) {
        return super.size() > 10;
    }
    
}
