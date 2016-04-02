package com.journaldev.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.journaldev.spring.service.EmployeeService;
import com.journaldev.spring.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringMain {
    
   
    private IEmployeeService employeeService;

    @Autowired
    public SpringMain(IEmployeeService employeeService) {
        this.employeeService = employeeService;
        System.out.println("The value is "+this);
    }

    
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//                EmployeeService s = new EmployeeService();
//		IEmployeeService employeeService = (IEmployeeService)ctx.getBean("employeeService");
                IEmployeeService employeeService = new SpringMain((IEmployeeService)ctx.getBean("employeeService")).employeeService;
                System.out.println("The class obtained is "+employeeService);
		System.out.println(employeeService.getEmployeeObj().getName());
		
//		employeeService.getEmployee().setName("Pankaj");
//		
//		employeeService.getEmployee().throwException();
		
		ctx.close();
	}

}
