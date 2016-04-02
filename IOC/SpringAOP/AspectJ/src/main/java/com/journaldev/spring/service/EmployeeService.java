package com.journaldev.spring.service;

import com.journaldev.spring.model.Employee;

public class EmployeeService  implements IEmployeeService{

    public EmployeeService() {
        System.out.println("The object of employee service is "+this);
    }
    
    

//    private Employee employee;
//
//    public Employee getEmployee() {
//        System.out.println("The value of service object is "+this);
//        return this.employee;
//    }
//
//    public void setEmployee(Employee e) {
//        this.employee = e;
//    }

    public Employee getEmployeeObj() {
        return new Employee();
    }
    
    public void dummyMethod(){
        System.out.println("Hi this is dummy");
    }
}
