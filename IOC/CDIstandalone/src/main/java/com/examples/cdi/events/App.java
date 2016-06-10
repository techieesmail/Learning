/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.cdi.events;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author SanghviR
 */
public class App {

    @Inject
    private Event<HelloEvent> event;

    public static void main(String[] args) {
        Weld weld = new Weld();
        try (WeldContainer container = weld.initialize()) {
            Instance<App> instApp = container.select(App.class);
            App app = instApp.get();
            app.event.fire(new HelloEvent(10));
            System.out.println("Firing second event");
            app.event.fire(new HelloEvent(20));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void eventObserver(@Observes HelloEvent event){
        System.out.println("Printing i value "+event.getI());
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //Events are more like function calls but with fire and listening mechanis. It is the same like
    // we call method . It is a single threaded model.Can be tested by thread.sleep
}
