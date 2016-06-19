/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.streamapi;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sanghvir
 */
public class App {
    public static void main(String[] args) {
        int[] i = {10,15,12,14,8,5,4,9,7,26};
        Arrays.stream(i).map((n) -> n*2).filter((n) -> n%2==0).forEach(System.out::println);
     }
}
