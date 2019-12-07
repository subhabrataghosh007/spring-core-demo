package com.demo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;

public class Init {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		EmployeeService testService = (EmployeeService) context.getBean("employeeService");

		
		// find all employee
		System.out.println("\n----------:find all employee:------------\n");
		List<Employee> list = testService.findAllEmployee();
		System.out.println(list);

		
		
		// ADD a new employee
		System.out.println("\n----------:ADD a new employee:------------\n");
		Employee employee = new Employee();
		employee.setId(103);
		employee.setName("Subha");
		employee.setSalary(2);
		testService.addNewEmployee(employee);
		System.out.println("New employee added successfully " + employee);
		System.out.println(testService.findAllEmployee());

		
		
		// DELETE an employee by ID
		System.out.println("\n----------:DELETE an employee by ID:------------\n");
		Integer id = 100;
		testService.deleteEmployeeById(id);
		System.out.println("Deleted employee " + id);
		System.out.println(testService.findAllEmployee());

		
		
		// Update an employee by ID
		System.out.println("\n----------:Update an employee by ID:------------\n");
		id = 100;
		Integer salary = 2000;
		int updatedSalary = testService.addSalaryById(id, salary);
		if (updatedSalary == 0) {
			System.out.println(id+" Not Found");
			System.out.println(testService.findAllEmployee());
		} else {
			System.out.println("Salary credited to " + id);
			System.out.println(testService.findEmployeeById(id));
		}
		
		id = 101;
		salary = 2000;
		updatedSalary = testService.addSalaryById(id, salary);
		if (updatedSalary == 0) {
			System.out.println(id+" Not Found");
			System.out.println(testService.findAllEmployee());
		} else {
			System.out.println("Salary credited to " + id);
			System.out.println(testService.findEmployeeById(id));
		}
		
		
		context.close();
	}

}
