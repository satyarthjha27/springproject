package com.example.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Courses;
import com.example.springboot.service.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@PostMapping("/courses")
	public Courses createCourses(@RequestBody Courses course) {
		logger.trace("POST COURSE CALLED");
		return courseService.createCourse(course);
	}
	
	@GetMapping("/courses")
	public List<Courses> getAllCourses(){
		logger.trace("GET ALL COURSE CALLED");
		return courseService.getAllCourses();
	}
	
	
	@GetMapping("/courses/{id}")
	public Courses getCourses(@PathVariable int id) {
		logger.trace("GET COURSE CALLED");
		return courseService.getCourses(id);
	}
	
	@PutMapping("/courses/{id}")
	public Courses updateCourses(@RequestBody Courses course, @PathVariable int id) {
		logger.trace("UPDATE COURSE CALLED");
		return courseService.updateCourse(course,id);
	}
	
	@DeleteMapping("courses/{id}")
	public void deleteCourses(@PathVariable int id) {
		logger.trace("DELETE COURSE CALLED");
		courseService.deleteCourse(id);
	}

}
