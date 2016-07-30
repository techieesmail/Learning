/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.streamapi;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 *
 * @author sanghvir
 */
public class App {
    public static void main(String[] args) {
        int[] i = {10,15,12,14,8,5,4,9,7,26};
        //Arrays.stream(i).map((n) -> n*2).filter((n) -> n%2==0).forEach(System.out::println);
        
        
        //Sum of squares of integers which are multiple of 3 
        IntStream.range(1, 101).
                map((m)-> {
                    //System.out.println("map "+m);
                    int square = m *m;
                    //System.out.println("map square "+square);
                    return square;
                }).
                filter((m) -> {
                    //System.out.println("filter "+m);
                    return  m%3 == 0;
                }).
                forEach(System.out::println);
        
        List<String> ls = new ArrayList<>();
     }
}
