/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.examples.javaee.cdi.cdistandalone;

import com.examples.cdi.alternatives.IBean;
import com.examples.cdi.interceptors.LoggingInterceptorBean;
import javax.inject.Inject;
import javax.inject.Named;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author Family
 */
public class App {
    //@Inject
    private IGreeting greeting;
    
    @Inject
    @Named("beana")
    private IBean bean;
    
    
    @Inject
    @Named("Stereobeana")
    private com.examples.cdi.stereotypes.IBean stereoBean;
    
    
    //@Inject can be used to inject on any methods.
//    @Inject
//    public void initialize(IGreeting greeting){
//        System.out.println("Hey initialize");
//        this.greeting = greeting;
//    }
//    
//    @Inject
//    public void initialize1(IGreeting greeting){
//        System.out.println("Hey initialize 2 ");
//        this.greeting = greeting;
//    }
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        
        //Interceptors
//        LoggingInterceptorBean logging = container.instance().select(LoggingInterceptorBean.class).get();
//        logging.sayHello();
        
        //Regular Injection
        App app = container.instance().select(App.class).get();
//        app.varTest("Rahul");
//        System.out.println(app.greeting.greet("Rahul"));
//        
//        
//        //Alternative Injection
//        app.bean.sayHello();
        
        //Stereotype injection
        app.stereoBean.sayHello();
    }
    
    public void varTest(String name,int...i){
        System.out.println("The name received is "+name);
    }
    
}
