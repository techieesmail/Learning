/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.cdi.stereotypes;

import javax.inject.Named;

/**
 *
 * @author SanghviR
 */
@StereoTypeAnnot
@Named("Stereobeana")
public class BeanA implements IBean{

    @Override
    @StereoInterceptorAnnot
    public void sayHello() {
        System.out.println("Hello from Stereotype bean a");
    }
    
}
