
package com.snsc.springproject.seviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snsc.springproject.model.Employee;
import com.snsc.springproject.repository.EmployeeRepository;
import com.snsc.springproject.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public void addEmpoyee(Employee employee) {
		emprepo.save(employee);

	}

	@Override
	public void deleteEmployee(long empId) {
		emprepo.deleteById(empId);
	}

	@Override
	public void updateEmployee(Employee employee) {
		emprepo.save(employee);
	}

	@Override
	public Employee getEmployeeById(long empId) {
		return emprepo.findById(empId).get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		return emprepo.findAll();
	}

}
