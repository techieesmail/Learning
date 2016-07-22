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
public class WorkerThread extends Thread{
    
    private Resource resource;
    
    public WorkerThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        if(this.getName().equalsIgnoreCase("nonSync")){
            resource.nonSynchronized();
           // Resource.nonSynchronized();
            //System.out.println("The value of shared variable is "+resource.sharedVariable);
        }else{
            //Resource.sync();
            resource.sync();
//            synchronized(resource){
//                resource.sync();
//            }
        }
    }
    
    
    
}
