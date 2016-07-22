/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author sanghvir
 */
public class MainClass {

    public static void main(String[] args) {
        list();
    }

    private static void list() {
        String[] s = {"Rahul", "Apeksha", "Sanghvi", "Shah"};
        List<String> ls = new ArrayList<>();
        ls.add("Rahul");
        ls.add("Apeksha");
        ls.add("Sanghvi");
        ls.add("Shah");

        Iterator<String> iter = ls.iterator(); // a flag indicating the count of elements is created when an iterator is created.
        //ls.remove(2); // any further operations update the same flag.
        while (iter.hasNext()) {
            System.out.println("In hasNext ");
            iter.next(); // this operation checks the actual flag value against the current value and if there is any chance throws an Exception
            // break;
        }

        //Advantage of loop over iterator is that Iterator throws Concurrent Modification Exception but with loops , we are directly accessing the 
        // index , so such an exception is not thrown.
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i));
            if (i == 0) {
                ls.remove(1);
            }
        }
        System.out.println(ls);
    }
}
