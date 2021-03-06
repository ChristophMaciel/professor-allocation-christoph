package com.project.professor.allocation.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Professor;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
public class ProfessorServiceTest {

	SimpleDateFormat sdf = new SimpleDateFormat("HH:mmZ");

	@Autowired
	ProfessorService professorService;

	@Test
	public void findAll() {
		// Act
		List<Professor> professor = professorService.findAll(null);

		// Print
		professor.forEach(System.out::println);
	}

	@Test
	public void findById() {
		// Arrange
		Long id = 1L;

		// Act
		Professor professor = professorService.findById(id);

		// Print
		System.out.println(professor);
	}

	@Test
	public void save() throws ParseException {
		// Arrange
		Professor professor = new Professor();
		professor.setCpf("98765432117");
		professor.setDepartmentId(1L);
		professor.setName("Cleto França");

		// Act
		professor = professorService.save(professor);

		// Print
		System.out.println(professor);
	}

	@Test
	public void update() throws ParseException {
		// Arrange
		Professor professor = new Professor();
		professor.setId(2L);
		professor.setCpf("98765432122");
		professor.setDepartmentId(1L);
		professor.setName("Mateus");

		// Act
		professor = professorService.update(professor);

		// Print
		System.out.println(professor);
	}

	@Test
	public void deleteById() {
		// Arrange
		Long id = 1L;

		// Act
		professorService.deleteById(id);
	}

	@Test
	public void deleteAll() {
		// Act
		professorService.deleteAll();
	}

}
