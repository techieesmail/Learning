/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.examples.cdi.stereotypes;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author SanghviR
 */
@Interceptor
@StereoInterceptorAnnot
public class StereoInterceptor {
    
    @AroundInvoke
    public Object invocation(InvocationContext t)throws Exception{
        System.out.println("Inside Invocation without qualify");
        return t.proceed();
    }
    
    @AroundInvoke
    public Object invocationWithQualify(InvocationContext t)throws Exception{
        System.out.println("Inside invocation with qualify ");
        return t.proceed();
    }
}
