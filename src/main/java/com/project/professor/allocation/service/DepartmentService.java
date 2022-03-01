package com.project.professor.allocation.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Department;

public class DepartmentService {

	@Service
	public interface DepartmentRepository extends JpaRepository<Department, Long> {

	}

}
