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

    public Resource(Lock lock) {
        this.lock = lock;
    }
    
    
     synchronized public void nonSynchronized() {
        System.err.println("Hey from non synchronization ");
    }

     public void sync() {
        try {
            System.out.println("Locking the lock ");
            //lock.lock();
            System.out.println("Sleeping the thread in sync ");
            Thread.sleep(60000);
            //wait(60000);
            System.out.println("After sleep completion in sync ");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            //lock.unlock();
        }
    }
}
