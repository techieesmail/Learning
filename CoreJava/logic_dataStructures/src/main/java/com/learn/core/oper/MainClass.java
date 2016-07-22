/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.oper;

/**
 *
 * @author sanghvir
 */
public class MainClass {

    public static void main(String[] args) {
        String s = "(+3(*52)(-63))";
        char[] ch = s.toCharArray();
        //for storing numbers and result of pattern from input string.
        int[] numbers = new int[s.length()];

        //getting the first operand
        char mainOperand = ch[1];
        int i = 2;
        int arrayIndex = -1;
        while (i < s.length()-1) {
            char c = ch[i];
            //incrementing the index so that the value can be added to numbers array
            arrayIndex++;
            if (c == '(') {
                //computing the numbers which are having the pattern (+96) and storing the result in numbers arrays
                numbers[arrayIndex] = compute(Character.getNumericValue(ch[i + 2]), Character.getNumericValue(ch[i + 3]), ch[i + 1]);
                i += 5;
            } else {
                numbers[arrayIndex] = Character.getNumericValue(c);
                i++;
            }

        }
        //main operation

        int result = compute(numbers[0], numbers[1], mainOperand);
        //Using arrayIndex for conditional check because arrayIndex holds the number of elements entered in the number array.
        for (int j = 2; j <= arrayIndex; j++) {
            result = compute(result, numbers[j], mainOperand);
        }

        System.out.println("The result is " + result);
    }

    private static int compute(int a, int b, char operand) {
        int result = 0;
        switch (operand) {
            case '*': {
                result = a * b;
                break;
            }
            case '+': {
                result = a + b;
                break;
            }
            case '-': {
                result = a - b;
                break;
            }
            case '/': {
                result = a / b;
                break;
            }
        }
        return result;
    }
}
