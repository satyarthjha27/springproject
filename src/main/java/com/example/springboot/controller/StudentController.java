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

import com.example.springboot.model.Students;
import com.example.springboot.service.StudentService;



@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@PostMapping("/students")
	public Students createStudents(@RequestBody Students student) {
		logger.trace("POST STUDENT CALLED");
		return studentService.createStudent(student);
	}
	
	@GetMapping("/students")
	public List<Students> getAllStudents(){
		logger.trace("GET ALL STUDENT CALLED");
		return studentService.getAllStudents();
	}
	
	
	@GetMapping("/students/{id}")
	public Students getStudents(@PathVariable int id) {
		logger.trace("GET STUDENT CALLED");
		return studentService.getStudents(id);
	}
	
	@PutMapping("/students/{id}")
	public Students updatStudents(@RequestBody Students student, @PathVariable int id) {
		logger.trace("UPDATE STUDENT CALLED");
		return studentService.updateStudent(student,id);
	}
	
	@DeleteMapping("students/{id}")
	public void deleteStudents(@PathVariable int id) {
		logger.trace("DELETE STUDENT CALLED");
		studentService.deleteStudent(id);
	}
	
	
	@PutMapping("/addcourse/{sid}/{cid}")
	//@CachePut (value="stu", key="#sid")
	public Students addCoursesToStudent (@PathVariable int sid, @PathVariable int cid) {
		return studentService.addCoursesToStudent(sid,cid) ;
	}
}
