package com.snsc.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snsc.springproject.model.Department;
import com.snsc.springproject.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService deptservice;

	@GetMapping("/department")
	public String getDepartment() {
		
		return "Department";
	}

	@PostMapping("/department")
	public String postDepartment(@ModelAttribute Department dept) {
		deptservice.addDepartment(dept);
		return "redirect:/departmentlist";
	}
	@GetMapping("/departmentlist")
	public String getAll(Model model) {
		model.addAttribute("dlist",deptservice.getAllDepartments());
		return "DepartmentList";
		
	}
	@GetMapping("/dept/delete")
	public String delete(@RequestParam int id) {
		deptservice.deleteDepartment(id);
		return "redirect:/departmentlist";
		
	}
	@GetMapping("/dept/edit")
	public String edit(@RequestParam int id, Model model) {
		model.addAttribute("dmodel",deptservice.getDepartmentById(id));
		return "DepartmentEditForm";
		
	}
	@PostMapping("/dept/update")
	public String updateDept(@ModelAttribute Department dept) {
		deptservice.updateDepartment(dept);
		return "redirect:/departmentlist";
		
	}
}
