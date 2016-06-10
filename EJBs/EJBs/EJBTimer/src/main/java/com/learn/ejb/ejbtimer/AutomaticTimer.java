/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.ejb.ejbtimer;

import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.Timer;

/**
 *
 * @author martin
 */
//@Singleton
@Stateless(name = "AutomaticTimer")
//@Lock(LockType.READ)
public class AutomaticTimer {

    //Since the beans are automatically managed by container and the bean methods automatically participate in transactions so there are chances that we get JTA timeout.
    @Schedule(second = "0/15", minute = "*", hour = "*",persistent = true)
    public void businessMethod() {
        try {
            System.out.println("The date when the schedule is running is " + new Date());
            System.out.println("The thread name is " + Thread.currentThread().getName());
            System.out.println("The instance name is " + this.getClass().getName());
            Thread.sleep(45000);
            System.err.println("After timeout in business method");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    @Timeout
//    public void timeOut(Timer timer){
//        System.err.println("In the timeout method "+timer.getNextTimeout());
//    }
//    @Timeout is applicable only for programmatic timers. 
//    Automatic timers timeout is decided by the schedule annotation. Timeout says what needs to be executed as per schedule.
    //http://www.adam-bien.com/roller/abien/entry/simplest_possible_ejb_3_16
}
