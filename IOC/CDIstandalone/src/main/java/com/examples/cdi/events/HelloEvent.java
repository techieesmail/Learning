/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.cdi.events;

/**
 *
 * @author SanghviR
 */
public class HelloEvent {

    private int i;
    public HelloEvent(int i) {
        this.i = i;
        System.out.println("Hello Event Triggered "+i);
    }

    public int getI() {
        return i;
    }
    
    
    
    
}
