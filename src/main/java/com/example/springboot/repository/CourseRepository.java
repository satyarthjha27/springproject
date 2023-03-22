package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Courses;

public interface CourseRepository extends JpaRepository<Courses,Integer>{

}
