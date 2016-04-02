/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.examples.javaee.cdi.cdistandalone;

import java.lang.annotation.Annotation;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import org.jboss.weld.environment.se.Weld;

/**
 *
 * @author Family
 */
public class App {
    @Inject
    private IGreeting greeting;
    
    public static void main(String[] args) {
        Weld weld = new Weld();
        App app = weld.initialize().instance().select(App.class).get();
        app.varTest("Rahul");
        System.out.println(app.greeting.greet("Rahul"));
    }
    
    public void varTest(String name,int...i){
        System.out.println("The name received is "+name);
    }
    
}
