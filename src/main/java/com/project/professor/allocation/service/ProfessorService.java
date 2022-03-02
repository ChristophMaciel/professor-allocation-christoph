package com.project.professor.allocation.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.ProfessorRepository;

@Service
public class ProfessorService {

	private ProfessorRepository professorRepository;

	public ProfessorService(ProfessorRepository professorRepository) {
		super();
		this.professorRepository = professorRepository;
	}

	// CRUD: Read All
	public List<Professor> findAll() {
		List<Professor> professor = professorRepository.findAll();
		return professor;
	}

	// CRUD: Read by ID
	public Professor findById(Long id) {
		return professorRepository.findById(id).orElse(null);
	}

	// CRUD: Create
	public Professor create(Professor professor) {
		professor.setId(null);
		professor = professorRepository.save(professor);
		return professor;
	}

	// CRUD: Update
	public Professor update(Professor professor) {
		Long id = professor.getId();
		if (id != null && professorRepository.existsById(id)) {
			professor = professorRepository.save(professor);
		} else {
			return null;
		}
		return professor;
	}

	// CRUD: Delete By Id
	public void deleteById(Long id) {
		if (professorRepository.existsById(id)) {
			professorRepository.deleteById(id);
		}

	}

	// CRUD: Delete All
	public void deleteAll() {

		professorRepository.deleteAll();
	}
}
