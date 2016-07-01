/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.datastructures.EVM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author sanghvir
 */
public class EVM {
    
    public static void main(String[] args) {
        String[] A = {"Modi","Sonia","Modi","Mohan","Modi","Sonia","Mohan","Yadav"};
        LinkedHashMap<String,Integer> hm = new LinkedHashMap<>();
        
        TreeMap<Integer , String> reverse = new TreeMap<>();
        
        for(String s : A){
            Integer value = hm.get(s);
            if(value == null){
                hm.put(s,1);
            }else{
                //int newVal = value++;
                hm.put(s, ++value);
            }
        }
        
        System.out.println("Map with count is "+hm);
        
        Set<String> names = hm.keySet();
        Iterator<String> namesIter = names.iterator();
        while(namesIter.hasNext()){
            String key = namesIter.next();
            reverse.put(hm.get(key), key);
        }
        System.out.println("Reverse Map with count "+reverse);
    }
}
