package com.example.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Courses;
import com.example.springboot.model.Students;
import com.example.springboot.repository.CourseRepository;
import com.example.springboot.repository.StudentRepository;



@Service
public class StudentService {
	
	
	
	Logger logger = LoggerFactory.getLogger(StudentService.class);

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	public Students createStudent(Students student) {
		return studentRepository.save(student);
	}

	@Cacheable(value="students")
	public List<Students> getAllStudents() {
		logger.trace("Called from database");
		List<Students> st=new ArrayList<>();
		studentRepository.findAll().forEach(st::add);
		return st;
	}

	@Cacheable(value = "students")
	public Students getStudents(int id) {
		logger.trace("Called from database");
		return studentRepository.findById(id).get();
		
	}

	public Students updateStudent(Students student, Integer id) {
		Students oldStudent = studentRepository.findById(id).orElse(null);
		if(oldStudent!=null) {
			oldStudent.setName(student.getName());
			oldStudent.setAge(student.getAge());
			return studentRepository.save(oldStudent);
		}
		return null;
		
	}
	
	public void deleteStudent(Integer id) {
		studentRepository.deleteById(id);
	}

	public Students addCoursesToStudent(int sid, int cid) {
		
		Students student = studentRepository.findById(sid).orElse(null);
		Courses course = courseRepository.findById(cid).orElse(null);
		student.setCourse(course);
		studentRepository.save(student);
		return student;
	}

}
