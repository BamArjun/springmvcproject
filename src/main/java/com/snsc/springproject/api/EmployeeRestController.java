package com.snsc.springproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.snsc.springproject.model.Employee;
import com.snsc.springproject.service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService empService;

	@GetMapping("/api/emp/list")
	public List<Employee> getAll() {

		return empService.getAllEmployee();

	}

	@GetMapping("/api/emp/{id}")
	public Employee getoneEmp(@PathVariable long id) {
		return empService.getEmployeeById(id);
	}

	@PostMapping("api/emp/add")
	public String add(@RequestBody Employee emp) {
		empService.addEmpoyee(emp);
		return "success";

	}

	@DeleteMapping("/api/emp/delete{}id")
	public String delete(@PathVariable long id) {
		empService.deleteEmployee(id);
		return "deleted success";
	}

	@PutMapping("/api/emp/update")
	public String Update(@RequestBody Employee emp) {
		empService.updateEmployee(emp);
		return "update success";
	}
	@GetMapping("/api/emp/j2o")
	 public String jsonObject() {
		
		RestTemplate rest = new RestTemplate();
		Employee emp=rest.getForObject("http://localhost:8080/api/emp/10", Employee.class);
		
		return "First Name="+ emp.getFname();
		 
	 }
 @GetMapping("/api/emp/ja2oa")
	public String jsonArrayToOdjarray() {
	RestTemplate rest = new RestTemplate();
	Employee[] emp=rest.getForObject("http://localhost:8080/api/emp/list", Employee[].class);
	return "Name"+emp[0].getFname()+""+emp[0].getLname();
		
	}
}
