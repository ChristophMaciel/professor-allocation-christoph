package com.project.professor.allocation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.professor.allocation.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
