package com.ajit.crud.service;

import java.util.List;

import com.ajit.crud.entity.Department;

public interface DepartmentService {

	public Department saveDeparment(Department dept);
	
	public List<Department> fetchDepartment();
	
	public Department updateDepartment(Department dept, Long id);
	
	public void deleteDepartmentById(Long id); 
	
	
}
