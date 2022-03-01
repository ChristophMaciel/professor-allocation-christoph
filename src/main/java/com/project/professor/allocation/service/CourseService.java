package com.project.professor.allocation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Professor;
import com.project.professor.allocation.repository.AllocationRepository;

@Service
public class CourseService {

	private final CourseService courseService;

	public CourseService(CourseService courseService) {
		super();
		this.courseService = courseService;
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

	public List<Course> findByCourse(Long courseId) {
		return courseRepository.findByCourseId(courseId);
	}

	// CRUD: Create
	public Course create(Course course) {
		course.setId(null);
		return saveInternal(course);
	}

	// CRUD: Update
	public Course update(Course course) {
		Long id = course.getId();
		if (id != null && courseRepository.existsById(id)) {
			return saveInternal(course);
		} else {
			return null;
		}
	}

	private Course saveInternal(Course course) {
		if (!isEndHourGreaterThanStartHour(course) || hasCollision(course)) {
			throw new RuntimeException();
		} else {
			course = courseRepository.save(course);

			Course course = courseService.findById(course.getCourseId());
			course.setCourse(course);

			return course;
		}
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
