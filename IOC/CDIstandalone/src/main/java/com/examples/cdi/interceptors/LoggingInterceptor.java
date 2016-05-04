/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.cdi.interceptors;

import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author SanghviR
 */
@Interceptor
@LoggingInterceptorAnnot
public class LoggingInterceptor {
    
    @AroundInvoke
    public Object simpleLogging(InvocationContext ctx)throws Exception{
        System.out.println(ctx.getMethod());
        Object obj = ctx.proceed();
        System.out.println(obj);
        return obj;
    }
    
    //void is applicable for around construct 
    @AroundConstruct
    public void simpleLoggingForClass(InvocationContext ic) throws Exception{
        System.out.println("Inside constructor logging "+ic.getConstructor());
        ic.proceed();
    }
}
