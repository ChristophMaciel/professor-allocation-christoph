package com.project.professor.allocation.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.repository.DepartmentRepository;

@Service
public class DepartmentService {

	private DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}

	// CRUD: Read All
	public List<Department> findAll() {
		List<Department> department = departmentRepository.findAll();
		return department;
	}

	// CRUD: Read by ID
	public Department findById(Long id) {
		return departmentRepository.findById(id).orElse(null);

	}

	// CRUD: Create
	public Department create(Department department) {
		department.setId(null);
		department = departmentRepository.save(department);
		return department;
	}

	// CRUD: Update
	public Department update(Department department) {
		Long id = department.getId();
		if (id != null && departmentRepository.existsById(id)) {
			department = departmentRepository.save(department);
		} else {
			return null;
		}
		return department;
	}

	// CRUD: Delete By Id
	public void deleteById(Long id) {
		if (departmentRepository.existsById(id)) {
			departmentRepository.deleteById(id);
		}
	}

	// CRUD: Delete All
	public void deleteAll() {

		departmentRepository.deleteAll();
	}
}
