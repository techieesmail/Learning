/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.core.javagenerics.methOverload;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generic {
    public static <K> List<K> method(final K arg, final Object... otherArgs) {
        System.out.println("I'm in one");
        return new ArrayList<K>();
    }

    public static  List method(final Object... otherArgs) {
        System.out.println("I'm in two");
        return new ArrayList();
    }

    public static <K, V> Map<K, V> method2(final K k0, final V v0, final Object... keysAndValues) {
        System.out.println("I'm in one");
        return new HashMap<K,V> ();
    }

    public static <K, V> Map<K, V> method2(final Object... keysAndValues) {
        System.out.println("I'm in two");
        return new HashMap<K,V>();
    }

    public static void main(String[] args) {
//        Map<String, Integer> c = Generic.method2( "ACD", new Integer(4), "DFAD" );
//        List<Integer> d = Generic.method(1, "2" );
    }
}
