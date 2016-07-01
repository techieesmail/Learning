/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.datastructures.number2words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sanghvir
 */
public class NumbersToWords {
    static String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"};
        
    static String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    static String[] grouping = {"","Million","Billion"};
    
    static String[] indianGroup = {"","Thousand","Lakh","Crore"};
    
    public static void main(String[] args) {
        long num = 352465891;
        //indianSystem(num);
        //usSystem(num);
        anotherIndianSystem();
    }
    
    static void indianSystem(long num) {
        Map m = new HashMap();
        m.put(3, "Hundred");
        m.put(4, "Thousand");
        m.put(6, "lakh");
        m.put(8, "crore");
        
        
        
        StringBuffer buff = new StringBuffer();
        String numStr = String.valueOf(num);
        System.out.println("The numStr is " + numStr);
        int numStrLen = numStr.length();
        for (int i = 0; i < numStrLen; i++) {
            int stringPos = numStrLen - i;
            int value = Character.getNumericValue(numStr.charAt(i));
            System.out.println("The value is " + value);
            //true for tens position
            if (stringPos % 2 == 1) {
                if (stringPos == 3) {
                    buff.append(ones[value]).append("\t").append(m.get(stringPos)).append("\t");
                } else if (stringPos == 1) {
                    buff.append(ones[value]).append("\t");
                } else {
                    buff.append(tens[value]).append("\t");
                }
                
            } else //true for ones
             if (stringPos == 2) {
                    buff.append(tens[value]).append("\t");
                } else {
                    buff.append(ones[value]).append("\t").append(m.get(stringPos) != null ? m.get(stringPos) : "").append("\t");
                }
        }
        System.out.println(buff.toString());
    }
    
    static void usSystem(long num){
        String numStr  = String.valueOf(num);
        StringBuffer buff = new StringBuffer("\t");
        
        int numStrLen = numStr.length();
        
        
        
        int group = numStrLen/3;
        long quotient = 0;
        long remainder = num;
        while(group > 0){
            long divValue = (long)Math.pow(1000, group-1);
            quotient = remainder /divValue;
            remainder = num % divValue;
            //send quotient for printing
            printQuotient(buff, quotient, group);
            if(remainder == 0){
                break;
            }
            numStrLen = String.valueOf(remainder).length();
            group = numStrLen/3;
        }
        
        System.out.println(buff);
   
    }
    
    static void printQuotient(StringBuffer buff , long quotient , int group){
        String s  = String.valueOf(quotient);
        int hundred  = Character.getNumericValue(s.charAt(0));
        int ten  = Character.getNumericValue(s.charAt(1));
        int one  = Character.getNumericValue(s.charAt(2));
        buff.append("\t");
        buff.append(ones[hundred]).append("Hundred \t").append("\t"+tens[ten]).append("\t"+ones[one]).append(grouping[group - 1]).append("\t");
    }
    
    
    
    
    public static void anotherIndianSystem(){
        long num = 123456789;
        StringBuffer temp = new StringBuffer("\t");
        String f = "";
        String numStr = String.valueOf(num);
        if(numStr.length() > 3){
            //splitting
            
            long belowHundred = num%1000;
            long aboveHundred = num / 1000;
            long remainder = 0;
            //process above hundred
            long quotient = aboveHundred;
            int place = 0;
            while(quotient !=0){
                temp.setLength(0);
                place++;
                remainder = quotient % 100;
                quotient = quotient/100;
                
                //print remainder
                int ten = (int)remainder / 10;
                int one = (int)remainder % 10;
                temp.append(tens[ten]).append("\t").append(ones[one]).append("\t").append(indianGroup[place]).append("\t");
                f = temp.toString() + f;
            }
            
             int h =(int) belowHundred / 100;
             int r = (int)belowHundred % 100;
             int ten = r / 10;
             int one = r % 10;
             f = f + ones[h] + " Hundred " + tens[ten] + ones[one];
            
            
        }else{
            //serve hundreds
        }
        System.out.println(f);
    }
    
    
    
    
    
}


// Another good implementation http://javahungry.blogspot.com/2014/05/convert-math-number-to-equivalent-readable-word-in-java-code-with-example.html