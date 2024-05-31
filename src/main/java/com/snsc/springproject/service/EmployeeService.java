package com.snsc.springproject.service;

import java.util.List;

import com.snsc.springproject.model.Employee;

public interface EmployeeService {
	void addEmpoyee(Employee employee);

	void deleteEmployee(long empId);

	void updateEmployee(Employee employee);

	Employee getEmployeeById(long empId);

	List<Employee> getAllEmployee();

}
