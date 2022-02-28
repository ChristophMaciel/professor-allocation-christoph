package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.AllocationRepository;
import com.project.professor.allocation.repository.CourseRepository;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class AllocationService {

	private final AllocationRepository allocationRepository;
	private final ProfessorRepository professorRepository;
	private final CourseRepository courseRepository;

	public AllocationService(AllocationRepository allocationRepository, ProfessorRepository professorRepository,
			CourseRepository courseRepository) {
		super();
		this.allocationRepository = allocationRepository;
		this.professorRepository = professorRepository;
		this.courseRepository = courseRepository;
	}

	// CRUD: Read All
	public List<Allocation> findAll() {
		List<Allocation> allocations = allocationRepository.findAll();
		return allocations;
	}

	// CRUD: Read by ID
	public Allocation findById(Long id) {
		Optional<Allocation> optional = allocationRepository.findById(id);
		Allocation allocation = optional.orElse(null);
		return allocation;
	}

	// CRUD: Create
	public Allocation create(Allocation allocation) {
		allocation.setId(null);
		return saveInternal(allocation);
	}

	// CRUD: Update
	public Allocation update(Allocation allocation) {
		Long id = allocation.getId();
		if (id != null && allocationRepository.existsById(id)) {
			return saveInternal(allocation);
		} else {
			return null;
		}
	}

	private Allocation saveInternal(Allocation allocation) {
		if (hasCollision(allocation)) {
			throw new RuntimeException("hasCollision");
		} else {
			Allocation allocationNew = allocationRepository.save(allocation);

			Professor professor = professorRepository.findById(allocationNew.getProfessorId()).orElse(null);
			Course course = courseRepository.findById(allocationNew.getCourseId()).orElse(null);

			allocationNew.setProfessor(professor);
			allocationNew.setCourse(course);

			return allocationNew;
		}

	}

	// CRUD: Delete By Id
	public void deleteById(Long id) {
		if (allocationRepository.existsById(id)) {
			allocationRepository.deleteById(id);

		}

	}

	// CRUD: Delete All
	public void deleteAll() {

		allocationRepository.deleteAllInBatch();

	}

	// Regra de Negócio
	boolean hasCollision(Allocation newAllocation) {
		boolean hasCollision = false;

		List<Allocation> currentAllocations = allocationRepository.findByProfessorId(newAllocation.getProfessorId());

		for (Allocation currentAllocation : currentAllocations) {
			hasCollision = hasCollision(currentAllocation, newAllocation);
			if (hasCollision) {
				break;
			}
		}

		return hasCollision;
	}

	private boolean hasCollision(Allocation currentAllocation, Allocation newAllocation) {
		return !currentAllocation.getId().equals(newAllocation.getId())
				&& currentAllocation.getDay() == newAllocation.getDay()
				&& currentAllocation.getStart().compareTo(newAllocation.getEnd()) < 0
				&& newAllocation.getStart().compareTo(currentAllocation.getEnd()) < 0;
	}

}
