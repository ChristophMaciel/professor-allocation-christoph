package com.project.professor.allocation.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.professor.allocation.entity.Course;

public class CourseService {

	@Service
	public interface CourseRepository extends JpaRepository<Course, Long> {

	}

}
