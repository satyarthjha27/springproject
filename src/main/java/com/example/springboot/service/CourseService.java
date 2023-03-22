package com.example.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Courses;
import com.example.springboot.repository.CourseRepository;

@Service
public class CourseService {
	
	
	Logger logger = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	private CourseRepository courseRepository;
	
	public Courses createCourse(Courses course) {
		return courseRepository.save(course);
	}

	public List<Courses> getAllCourses() {
		List<Courses> ct=new ArrayList<>();
		courseRepository.findAll().forEach(ct::add);
		return ct;
	}

	//@Cacheable(value = "courses",key="#id")
	public Courses getCourses(int id) {
		logger.trace("Called from database");
		return courseRepository.findById(id).get();
		
	}

	public Courses updateCourse(Courses course, Integer id) {
		Courses oldCourse = courseRepository.findById(id).orElse(null);
		if(oldCourse!=null) {
			oldCourse.setName(course.getName());
			oldCourse.setPrice(course.getPrice());
			return courseRepository.save(oldCourse);
		}
		return null;
		
	}
	
	public void deleteCourse(Integer id) {
		courseRepository.deleteById(id);
	}

}
