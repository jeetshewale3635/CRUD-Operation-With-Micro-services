package com.ajit.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajit.crud.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
