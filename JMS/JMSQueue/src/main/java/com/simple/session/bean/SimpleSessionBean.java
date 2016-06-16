/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.simple.session.bean;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Family
 */
@Stateless
@LocalBean
public class SimpleSessionBean {

    public int addNumbers(int number1, int number2) {
        return number1+number2;
    }

    
}
