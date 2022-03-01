package com.project.professor.allocation.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Professor;

public class ProfessorService {

	@Service
	public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	}

}
