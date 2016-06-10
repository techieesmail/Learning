/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.ejb.ejbtimer;

import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.ScheduleExpression;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerConfig;
import javax.ejb.TimerService;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author SanghviR
 */
@Stateless(name = "programmaticTimer")
@Startup
@WebService
public class ProgrammaticTimer {
    
    
    @Resource
    private TimerService timer;
    
    //@PostConstruct
    @Oneway
    public void createTimer(){
        TimerConfig config = new TimerConfig();
        config.setInfo("programmaticTimer");
        config.setPersistent(true);
        
        
        ScheduleExpression schedule = 
        new ScheduleExpression().second("0/15").minute("*").hour("*");
        
        timer.createCalendarTimer(schedule, config);
    }
    
    
    //The below code will be executed as per the schedule.
    @Timeout
    @WebMethod(exclude = true)
    public void timeOut(Timer timer){
        System.out.println("This is the programme that will be executed "+new Date());
        try {
            System.out.println("Current thread is "+Thread.currentThread().getName());
            System.out.println("Current instance is "+this.getClass().getName());
            //Thread.sleep(21000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //http://www.adam-bien.com/roller/abien/entry/simplest_possible_ejb_3_17
}
