package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;

public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	public List<Employee> findAllEmployee() {
		return repository.finaAllEmployee();
	}
	
	public Employee findEmployeeById(Integer id) {
		return repository.finaById(id);
	}

	public void setRepository(EmployeeRepository repository) {
		this.repository = repository;
	}

	public void addNewEmployee(Employee employee) {
		repository.save(employee);
	}

	public void deleteEmployeeById(int id) {
		repository.deleteById(id);
	}

	public int addSalaryById(Integer id, Integer salary) {
		System.out.println("Update employee "+id);
		return repository.addSalary(id, salary);
	}
}
