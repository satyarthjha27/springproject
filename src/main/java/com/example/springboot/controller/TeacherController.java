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

import com.example.springboot.model.Teachers;
import com.example.springboot.service.TeacherService;

@RestController
public class TeacherController {

	
	
	@Autowired
	private TeacherService teacherService;
	
	Logger logger = LoggerFactory.getLogger(TeacherController.class);
	
	@PostMapping("/teachers")
	public Teachers createTeachers(@RequestBody Teachers teacher) {
		logger.trace("POST TEACHER CALLED");
		return teacherService.createTeachers(teacher);
	}
	
	@GetMapping("/teachers")
	public List<Teachers> getAllTeachers(){
		logger.trace("GET ALL TEACHER CALLED");
		return teacherService.getAllTeachers();
	}
	
	
	@GetMapping("/teachers/{id}")
	public Teachers getTeachers(@PathVariable int id) {
		logger.trace("GET TEACHER CALLED");
		return teacherService.getTeachers(id);
	}
	
	@PutMapping("/teachers/{id}")
	public Teachers updatTeachers(@RequestBody Teachers teacher, @PathVariable int id) {
		logger.trace("UPDATE TEACHER CALLED");
		return teacherService.updateTeacher(teacher,id);
	}
	
	@DeleteMapping("teachers/{id}")
	public void deleteTeachers(@PathVariable int id) {
		logger.trace("DELETE TEACHER CALLED");
		teacherService.deleteTeacher(id);
	}
	
	@PutMapping("/addstudent/{tid}/{sid}")
	public Teachers addStudent(@PathVariable int tid, @PathVariable int sid) {
		
		return teacherService.addStudent(tid,sid);
	}
	
}
