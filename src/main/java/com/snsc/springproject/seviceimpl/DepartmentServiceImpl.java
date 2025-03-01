package com.snsc.springproject.seviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snsc.springproject.model.Department;
import com.snsc.springproject.repository.DepartmentRepository;
import com.snsc.springproject.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository deprepo;

	@Override
	public void addDepartment(Department dept) {
		deprepo.save(dept);
	}

	@Override
	public void deleteDepartment(int id) {
		deprepo.deleteById(id);
	}

	@Override
	public void updateDepartment(Department dept) {
		deprepo.save(dept);
	}

	@Override
	public Department getDepartmentById(int id) {
		return deprepo.findById(id).get();
	}

	@Override
	public List<Department> getAllDepartments() {
		return deprepo.findAll();
	}

}