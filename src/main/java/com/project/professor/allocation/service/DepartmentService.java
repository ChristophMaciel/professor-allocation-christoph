package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.project.professor.allocation.entity.Department;

@Service
public class DepartmentService {

	private DepartmentService departmentService;
	private Long departmentId;
	public DepartmentService(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;

	}

	// CRUD: Read All
	public List<Department> findAll() {
		List<Department> department = departmentService.findAll();
		return department;
	}

	// CRUD: Read by ID
	public Department findById(Long id) {
		Optional<Department> optional = Optional.ofNullable(departmentService.findById(id));
		Department department = optional.orElse(null);
		return department;
	}

	public List<Department> findByDepartment(Long department) {
		return departmentService.findByDepartment(departmentId);
	}

	// CRUD: Create
	public Department create(Department department) {
		department.setId(null);
		return saveInternal(department);
	}

	private Department saveInternal(Department department) {
		// TODO Auto-generated method stub
		return null;
	}

	// CRUD: Update
	public Department update(Department department) {
		Long id = department.getId();
		if (id != null && departmentService.existsById(id)) {
			return saveInternal(department);
		} else {
			return null;
		}
	}

	private boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	// CRUD: Delete By Id
	public void deleteById(Long id) {
		if (departmentService.existsById(id)) {
			departmentService.deleteById(id);

		}

	}

	// CRUD: Delete All
	public void deleteAll() {

		departmentService.deleteAll();

	}
}
