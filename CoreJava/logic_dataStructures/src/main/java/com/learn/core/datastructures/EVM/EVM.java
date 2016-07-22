/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.datastructures.EVM;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 *
 * @author sanghvir
 */
public class EVM {
    
    public static void main(String[] args) {
        String[] A = {"Modi","Sonia","Modi","Mohan","Mohan","Sonia","Modi","Yadav"};
        HashMap<String,Integer> hm = new HashMap<>();
        TreeMap<Integer,LinkedList<String>> tm = new TreeMap<>();
        
        for(String s : A){
            Integer value = hm.get(s);
            if(value == null){
                value = 1;
            }else{
              value++;
            }
            hm.put(s,value);
            
            
            LinkedList<String> candidates = tm.get(value);
            if(candidates == null){
                LinkedList<String> ll = new LinkedList<>();
                ll.addFirst(s);
                tm.put(value, ll);
            }else{
                candidates.addFirst(s);
                tm.put(value, candidates);
            }
                
        }
        
        System.out.println("Map with count is "+hm);
        
        tm.keySet().stream().forEach((tmKey) -> {
            System.out.println("Name -----    "+tm.get(tmKey).getFirst()+"   Count-----   "+tmKey);
        
        });
    }
}
