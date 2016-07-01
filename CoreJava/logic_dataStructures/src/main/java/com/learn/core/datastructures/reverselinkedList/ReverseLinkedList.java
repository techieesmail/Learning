/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.datastructures.reverselinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author sanghvir
 */
public class ReverseLinkedList {

    
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(15);
        ll.add(12);
        ll.add(20);
        ll.add(8);
        
        System.out.println("Original linked list "+ll);
        
        List<Integer> sub = ll.subList(0, 2);
        List<Integer> ss = ll.subList(3, ll.size());
        Collections.reverse(sub);
        
        
        LinkedList<Integer> newLs = new LinkedList<>();
        newLs.addAll(sub);
        newLs.addAll(ss);
        System.out.println("After reversing entire list "+newLs );
        
    }

    
    
    
}


