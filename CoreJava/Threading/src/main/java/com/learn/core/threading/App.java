/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.threading;

/**
 *
 * @author sanghvir
 */
public class App {
    public static void main(String[] args)throws Exception {
        Resource r = new Resource();
        WorkerThread sync = new WorkerThread(r);
        WorkerThread nonSync = new WorkerThread(r);
        nonSync.setName("nonSync");
        System.out.println("Starting sync thread ");
        sync.start();
        Thread.sleep(3000);
        System.out.println("Starting non sync thread ");
        nonSync.start();
    }
}
