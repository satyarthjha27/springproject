package com.example.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.springboot.model.Students;
import com.example.springboot.model.Teachers;
import com.example.springboot.repository.StudentRepository;
import com.example.springboot.repository.TeacherRepository;

@Service
public class TeacherService {

	Logger logger = LoggerFactory.getLogger(TeacherService.class);

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Teachers createTeachers(Teachers teacher) {
		return teacherRepository.save(teacher);
	}

	@Cacheable(value="teacher")
	public List<Teachers> getAllTeachers() {
		List<Teachers> st=new ArrayList<>();
		logger.trace("Called from database");
		teacherRepository.findAll().forEach(st::add);
		return st;
	}

	@Cacheable(value = "teachers")
	public Teachers getTeachers(int id) {
		logger.trace("Called from database");
		return teacherRepository.findById(id).get();
		
	}

	public Teachers updateTeacher(Teachers teacher, Integer id) {
		Teachers oldTeacher = teacherRepository.findById(id).orElse(null);
		if(oldTeacher!=null) {
			oldTeacher.setName(teacher.getName());
			return teacherRepository.save(oldTeacher);
		}
		return null;
		
	}
	
	public void deleteTeacher(Integer id) {
		teacherRepository.deleteById(id);
	}

	public Teachers addStudent(int tid, int sid) {
		Teachers teacher = teacherRepository.findById(tid).orElse(null);
		Students student = studentRepository.findById(sid).orElse(null);
		if(teacher!=null && student!=null) {
			teacher.setStudent(student);
			teacherRepository.save(teacher);
			return teacher;
		}
		return null;
	}

	
}
