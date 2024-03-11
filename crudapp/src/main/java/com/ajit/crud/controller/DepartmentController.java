package com.ajit.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajit.crud.entity.Department;
import com.ajit.crud.service.DepartmentService;


@RestController
class DepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	@PostMapping("/departments")
	public Department saveDept(@RequestBody Department dept) {
		return deptService.saveDeparment(dept);
	}
	
	
	@GetMapping("/departments")
	public List<Department> getdepartments() {
		return deptService.fetchDepartment();
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDept(@RequestBody Department dept, @PathVariable("id") Long id ) {
		return deptService.updateDepartment(dept, id);
	}
	
	@DeleteMapping("/departments/{id}")
	public boolean deleteDept(@PathVariable("id") Long id) {
		deptService.deleteDepartmentById(id);
		return true;
	}
	
	/*
	 * @ExceptionHandler(value = NoSuchDepartmentExists.class)
	 * 
	 * @ResponseStatus(HttpStatus.CONFLICT) public ErrorResponse
	 * handleCustomerAlreadyExistsException(NoSuchDepartmentExists ex) { return new
	 * ErrorResponse(1002,ex.getMessage()); }
	 */
}
