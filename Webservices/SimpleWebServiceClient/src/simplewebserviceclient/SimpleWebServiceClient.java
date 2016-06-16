/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simplewebserviceclient;

import com.sample.service.client.CustomException_Exception;
import com.sample.service.client.Employee;
import com.sample.service.client.TestOperation;
import com.sample.service.client.TestOperationResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Family
 */
public class SimpleWebServiceClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
           Employee employee =  empReturn("Kapil");
            System.out.println("The id of the employee is "+employee.getId());
        } catch (CustomException_Exception ex) {
            ex.getFaultInfo().getExceptId();
            ex.printStackTrace();
        }
        
//        TestOperation oper = new TestOperation();
//        oper.setName("Rahul");
//        testOperation(oper, "customHeader");
        

    }

    private static TestOperationResponse testOperation(com.sample.service.client.TestOperation parameters, java.lang.String myHeader) {
        com.sample.service.client.SampleServiceDemo service = new com.sample.service.client.SampleServiceDemo();
        com.sample.service.client.SimpleService port = service.getSimpleServicePort();
        return port.testOperation(parameters, myHeader);
    }

    private static Employee empReturn(java.lang.String empName) throws CustomException_Exception {
        com.sample.service.client.SampleServiceDemo service = new com.sample.service.client.SampleServiceDemo();
        com.sample.service.client.SimpleService port = service.getSimpleServicePort();
        return port.empReturn(empName);
    }
    
}
