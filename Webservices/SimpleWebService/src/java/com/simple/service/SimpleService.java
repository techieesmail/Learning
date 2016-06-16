/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simple.service;

import com.service.fault.CustomException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Holder;

/**
 *
 * @author Family
 */
//@WebService(serviceName = "SampleServiceDemo")
@WebService(serviceName = "TestService",name = "testXYZ")

//@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SimpleService {

    /**
     * This is a sample web service operation
     */
   // @WebMethod(exclude = true)
    @WebResult(name="FullName")
    public String testOperation(@WebParam(name = "rahulabc") String txt,@WebParam(name="secondReturn",mode= WebParam.Mode.OUT)Holder<String> sec,
    @WebParam(name="myHeader",header=true)String headerParam) {
        
        sec.value = "123456";
        try {
            //throw new NullPointerException("Sample Exception");
            System.out.println("Sleeping the server side thread");
            Thread.sleep(5000);
            
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return "Hello " + txt + " !";
       
        
    }
    
//    @WebMethod(operationName = "hello")
//    @WebResult(name="FullName")
//    public String hello(@WebParam(name = "name") String txt) {
//        try {
//            //sec.value = "Second";
//            Thread.sleep(10000);
//        } catch (InterruptedException ex) {
//           ex.printStackTrace();
//        }
//        return "Hello " + txt + " !";
//        
//        
//    }

  // @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
    @WebResult(name = "empName")
    @WebMethod(exclude = false,operationName = "HelloOperation")
    public String hello(@WebParam(name = "inputName")Employee name,@WebParam(header = true)String xxx){
        //holder.value = "Krishna from second response";
        return "Hello "+name.getName();
    }
    
    @WebResult(name = "empDetails")
    public Employee empReturn(@WebParam(name="empName")String name)throws CustomException
    {
//        Employee c = new Employee();
//        c.setId(100);
//        c.setName(name);
        //try {
           // Thread.sleep(15000);
            // return c;
            //Exception ex = (Exception)new CustomException();
        CustomException ex = new CustomException();
 
        ex.setExceptId(1250);
        ex.setExcepType("TestException");
        
        throw ex;
//        } catch (Exception ex) {
//            Logger.getLogger(SimpleService.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        //return c;
    }
}
