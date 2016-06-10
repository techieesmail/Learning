/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learn.jpa.restservice;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author SanghviR
 */
@Interceptor
@RequireTransaction
public class TransactionInterceptorImpl {

    @javax.annotation.Resource(mappedName = "javax.transaction.UserTransaction")
    private UserTransaction tx;

    @AroundInvoke
    public Object initiateTransaction(InvocationContext ctx) throws Exception {
        try {
            tx.begin();
            Object ret = ctx.proceed();
            tx.commit();
            return ret;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        }

    }
}
