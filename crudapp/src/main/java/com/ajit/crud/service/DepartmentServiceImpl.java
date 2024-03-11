package com.ajit.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajit.crud.entity.Department;
import com.ajit.crud.exception.NoSuchDepartmentExists;
import com.ajit.crud.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository deptRepoObj;
	
	@Override
	public Department saveDeparment(Department dept) {
		
		return deptRepoObj.save(dept);	
	}

	@Override
	public List<Department> fetchDepartment() {
		
		return deptRepoObj.findAll();
	}

	@Override
	public Department updateDepartment(Department dept, Long id) {
		
		Optional<Department> dObj = deptRepoObj.findById(id);
		if(dObj.isPresent()) {
			System.out.println("Get call");
			dept.setDepartmentId(id);
			return deptRepoObj.save(dept);
		}else {
			System.out.println("Get call update -------------");
			throw new NoSuchDepartmentExists("No such department exists with id ="+id);
		}
	}

	@Override
	public void deleteDepartmentById(Long id) {
		Optional<Department> dObj = deptRepoObj.findById(id);
		if(dObj.isPresent()) {
			deptRepoObj.deleteById(id);
		}else {
			throw new NoSuchDepartmentExists("No such department exists with id ="+id);
		}		
	}

}
