/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.threading;

import java.util.concurrent.locks.Lock;

/**
 *
 * @author sanghvir
 */
public class Resource {

    private Lock lock;

    private Object syncObj = new Object();

    public Resource(Lock lock) {
        this.lock = lock;
    }

    public Integer sharedVariable = 10;

    public void nonSynchronized() {
        synchronized (syncObj) {
            System.err.println("Hey from non synchronization ");
        }
        //System.err.println("Hey from non synchronization ");
    }

    public void sync() {

        synchronized (syncObj) {

            try {
                //System.out.println("Locking the lock ");
                //lock.lock();
                System.out.println("Sleeping the thread in sync ");
                Thread.sleep(60000);
                //wait(60000);
                System.out.println("After sleep completion in sync ");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //lock.unlock();
            }

        }

    }

//    synchronized static public void nonSynchronized() {
//        System.err.println("Hey from non synchronization ");
//    }
//
//     synchronized static public void sync() {
//        try {
//            //System.out.println("Locking the lock ");
//            //lock.lock();
//            System.out.println("Sleeping the thread in sync ");
//            Thread.sleep(60000);
//            //wait(60000);
//            System.out.println("After sleep completion in sync ");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally{
//            //lock.unlock();
//        }
//    }
}
