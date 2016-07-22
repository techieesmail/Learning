/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.core.threading.fork;

import java.util.concurrent.RecursiveTask;

/**
 *
 * @author sanghvir
 */
public class Main {

    public static void main(String[] args) {
        double start = 0;
        double end = 1000000000L;
        SumTask mainTask = new SumTask(start, end, true);

        double sum = mainTask.invoke().longValue();
        
        
        //for single thread calculation
        //sum = sum + end;
        
        System.out.println(sum);

    }

}

class SumTask extends RecursiveTask<Double> {

    private static volatile double sum = 0;

    final private double start;
    final private double end;
    private boolean isMasterTask = false;

    private double elements;

    public SumTask(double start, double end) {
        //System.out.println("Constructor called " + start + "  " + end);
        this.start = start;
        this.end = end;
    }

    public SumTask(double start, double end, boolean isMasterTask) {
        this.start = start;
        this.end = end;
        this.isMasterTask = isMasterTask;
    }

    @Override
    protected Double compute() {
        elements = end - start;

        if (isMasterTask) {
            //System.out.println("In Main Task subdivision ");
            int availableProcessor = Runtime.getRuntime().availableProcessors();
            //System.out.println("No. of processors available in the machine " + availableProcessor);
            int threshold = 5000;
            taskBreakDown(threshold);
            return sum;
        } else {
            return computeSummation();
        }
    }

    private Double computeSummation() {
        double summ = 0;
        //System.out.println("The start and end for each task is " + this.start + "   " + this.end);
        for (double j = this.start; j < this.end; j++) {
            summ = summ + j;
        }
        //System.out.println("The sum for each task is " + summ);
        return summ;
    }

    private void taskBreakDown(int distributor) {
        double elementPerTask = elements / distributor;
        double taskRemainder = elements % distributor;

        int i = 1;
        while (i < distributor) {
            double end = elementPerTask * i;
            double start = end - elementPerTask;
            SumTask s = new SumTask(start, end);
            i++;
            updateSum(s.invoke());

        }

        //This is the last condition
        if (i == distributor) {
            double end = elementPerTask * i + taskRemainder;
            double start = end - elementPerTask;
            SumTask last = new SumTask(start, end);
            updateSum(last.invoke());
        }

        //update the last value
        updateSum(this.end);
    }

    private synchronized static void updateSum(double smallerSum) {
        sum = sum + smallerSum;
    }

}
