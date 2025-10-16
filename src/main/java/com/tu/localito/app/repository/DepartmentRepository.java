package com.tu.localito.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tu.localito.app.model.Department;


public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
