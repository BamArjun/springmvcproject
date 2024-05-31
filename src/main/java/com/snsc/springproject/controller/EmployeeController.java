package com.snsc.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snsc.springproject.model.Department;
import com.snsc.springproject.model.Employee;
import com.snsc.springproject.service.DepartmentService;
import com.snsc.springproject.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empservice;
	@Autowired
	private DepartmentService deptService;

	@GetMapping("/employee")
	public String getEmployee(Model model) {
		model.addAttribute("dlist",deptService.getAllDepartments());
		return "EmployeeForm";
	}
	
	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee employee) {
		empservice.addEmpoyee(employee);
		return "redirect:/employee";	
	}
	@GetMapping("/employeelist")
	public String getAll(Model model) {
		model.addAttribute("elist",empservice.getAllEmployee());
		return "EmployeeList";	
	}
	@GetMapping("/emp/delete")
	public String DeleteEmp(@RequestParam long id) {
		empservice.deleteEmployee(id);
		return "redirect:/employeelist";	
	}
	
	@GetMapping("/emp/edit")
	public String EditEmployee(@RequestParam long id, Model model) {
		model.addAttribute("emodel" ,empservice.getEmployeeById(id));
		model.addAttribute("dlist",deptService.getAllDepartments());

		return "EmployeeEditForm";	
	}
	@PostMapping("/emp/update")
	public String updateEmployee(@ModelAttribute Employee employee) {
		empservice.updateEmployee(employee);
		return "redirect:/employeelist";	
	}
	@GetMapping("/emp/view")
	public String viewEmployee(@RequestParam long id , Model model) {
		model.addAttribute("emodel" ,empservice.getEmployeeById(id));
		model.addAttribute("dlist",deptService.getAllDepartments());
		return "ViewHtml";
	}
	@GetMapping("/back")
	public String back() {
		return "redirect:/employeelist";
		
	}
}
