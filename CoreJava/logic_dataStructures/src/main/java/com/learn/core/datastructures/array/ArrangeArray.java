/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.datastructures.array;

import java.util.Arrays;

/**
 *
 * @author SanghviR
 */
public class ArrangeArray {
    
    public static void main(String[] args) {
        int[] a = {-6,-4,2,3,-7};
        
       // Arrays.sort(a);
        
       for(int i=0 ; i< a.length -1; i++){
           int op = a[i];
           for(int j = i+1 ; j < a.length ; j++){
               int ip = a[j];
               if(op > ip){
                   a[i] = ip;
                   a[j] = op;
               }else{
                   continue;
               }
           }
       }
        System.out.println(a[4]);
    }
    
}
