package com.demo.repository;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.demo.model.Employee;

public class EmployeeRepository {

	private Map<Integer, Employee> storage;

	public EmployeeRepository() {
	}

	public EmployeeRepository(Map<Integer, Employee> storage) {
		this.storage = storage;
	}

	public List<Employee> finaAllEmployee() {
		return storage.entrySet().stream().map(m -> m.getValue()).collect(Collectors.toList());
	}

	public Employee finaById(Integer id) {
		
		Employee employee = storage.entrySet().stream().filter(p -> p.getKey() == id).map(m -> m.getValue()).findFirst().get();
		return employee;
	}
	
	public void save(Employee employee) {
		storage.put(employee.getId(), employee);
	}

	public void deleteById(int id) {
		storage.remove(id);
	}

	public int addSalary(Integer id, Integer salary) {
		Employee e;
		if (null != (e = storage.get(id))) {
			e.setSalary(e.getSalary()+salary);
			return e.getSalary()+salary;
		} else {
			return 0;
		}
	}
}
