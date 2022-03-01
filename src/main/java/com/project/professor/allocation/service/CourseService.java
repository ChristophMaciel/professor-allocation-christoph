package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;

	public CourseService(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	// CRUD: Read All
	public List<Course> findAll() {
		List<Course> course = courseRepository.findAll();
		return course;
	}

	// CRUD: Read by ID
	public Course findById(Long id) {
		Optional<Course> optional = courseRepository.findById(id);
		Course course = optional.orElse(null);
		return course;
	}

	// CRUD: Create
	public Course create(Course course) {
		course.setId(null);
		course = courseRepository.save(course);
		return course;

	}

	// CRUD: Update
	public Course update(Course course) {
		Long id = course.getId();
		if (id != null && courseRepository.existsById(id)) {
			course = courseRepository.save(course);
		} else {
			return null;
		}
		return course;

	}

	// CRUD: Delete By Id
	public void deleteById(Long id) {
		if (courseRepository.existsById(id)) {
			courseRepository.deleteById(id);
		}

	}

	// CRUD: Delete All
	public void deleteAll() {

		courseRepository.deleteAllInBatch();

	}

}
