package com.snsc.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snsc.springproject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
