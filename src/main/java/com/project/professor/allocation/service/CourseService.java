package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Course;

@Service
public class CourseService {

	private CourseService courseService;

	public CourseService(CourseService courseService) {
		super();
		this.courseService = courseService;

	}

	// CRUD: Read All
	public List<Course> findAll() {
		List<Course> course = courseService.findAll();
		return course;
	}

	// CRUD: Read by ID
	public Course findById(Long id) {
		Optional<Course> optional = Optional.ofNullable(courseService.findById(id));
		Course course = optional.orElse(null);
		return course;
	}

	public List<Course> findByCourse(Long professorId) {
		return courseService.findByCourse(professorId);
	}

	// CRUD: Create
	public Course create(Course course) {
		course.setId(null);
		return saveInternal(course);
	}

	private Course saveInternal(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

	// CRUD: Update
	public Course update(Course course) {
		Long id = course.getId();
		if (id != null && courseService.existsById(id)) {
			return saveInternal(course);
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
		if (courseService.existsById(id)) {
			courseService.deleteById(id);

		}

	}

	// CRUD: Delete All
	public void deleteAll() {

		courseService.deleteAll();

	}
}
