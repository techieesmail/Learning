/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.lambda;

/**
 *
 * @author sanghvir
 */
public interface DefaultInter2 {
    default void whoami(){
        System.out.println("I am a default inter2 interace ");
    }
}
