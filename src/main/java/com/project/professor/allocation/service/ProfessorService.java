package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Professor;

@Service
public class ProfessorService {

	private ProfessorService professorService;

	public ProfessorService(ProfessorService professorService) {
		super();
		this.professorService = professorService;

	}

	// CRUD: Read All
	public List<Professor> findAll() {
		List<Professor> professor = professorService.findAll();
		return professor;
	}

	// CRUD: Read by ID
	public Professor findById(Long id) {
		Optional<Professor> optional = Optional.ofNullable(professorService.findById(id));
		Professor professor = optional.orElse(null);
		return professor;
	}

	public List<Professor> findByProfessor(Long professorId) {
		return professorService.findByProfessor(professorId);
	}

	// CRUD: Create
	public Professor create(Professor professor) {
		professor.setId(null);
		return saveInternal(professor);
	}

	private Professor saveInternal(Professor professor) {
		// TODO Auto-generated method stub
		return null;
	}

	// CRUD: Update
	public Professor update(Professor professor) {
		Long id = professor.getId();
		if (id != null && professorService.existsById(id)) {
			return saveInternal(professor);
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
		if (professorService.existsById(id)) {
			professorService.deleteById(id);

		}

	}

	// CRUD: Delete All
	public void deleteAll() {

		professorService.deleteAll();

	}
}
