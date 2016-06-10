/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.quartz;

import java.util.Date;
import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author SanghviR
 */
public class MainClass {

    private static Logger logger = LoggerFactory.getLogger(MainClass.class);

    public static void main(String[] args) throws Exception {
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        for (int i = 0; i < 50; i++) {
            JobDetail jobDetail = JobBuilder.newJob(MyJob.class).
                    withIdentity(String.valueOf(i)).build();
            Trigger trigger = TriggerBuilder.newTrigger().
                    withIdentity(String.valueOf(i)).withSchedule(CronScheduleBuilder.cronSchedule("0/1 * * * * ?")).build();
            logger.info("Scheduling job " + jobDetail.getKey().getName());
            scheduler.scheduleJob(jobDetail, trigger);
        }

        logger.info("Total scheduled jobs ");
        //Thread.sleep(20000);
        System.err.println("***************  " + scheduler.getJobKeys(GroupMatcher.anyJobGroup()));
        
//        Class<MyJob> c = MyJob.class;
//        c.newInstance();

    }

    public static class MyJob implements Job {

        public MyJob() {
        }

        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            System.err.println(new Date() + "   ----  The execute method of job called is " + context.getJobDetail().getKey());
        }

    }
}
