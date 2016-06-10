/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shared.classes;

import java.io.Serializable;

/**
 *
 * @author SanghviR
 */
public class SharedClass implements IShared{
    public int i;
    public void printI(){
        System.out.println("The value of i in shared class  "+this.i);
    }
    
    public void exec(){
        new ExecClass().exec();
    }
}
