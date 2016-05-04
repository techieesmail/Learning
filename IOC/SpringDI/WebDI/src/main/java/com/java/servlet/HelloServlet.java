/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.servlet;

import com.examples.spring.SessionBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 *
 * @author SanghviR
 */
public class HelloServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       SessionBean sess = (SessionBean)WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean("sessionBean");
        //System.out.println(WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBeanDefinitionNames().length);
       sess.sayHello();
    }
    
    
    
}
