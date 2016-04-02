/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.examples.javaee.cdi.cdistandalone;

import java.io.Serializable;

/**
 *
 * @author Family
 */
public interface IGreeting extends Serializable{
    public String greet(String name);
}
