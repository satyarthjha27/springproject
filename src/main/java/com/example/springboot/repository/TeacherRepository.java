package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Teachers;

public interface TeacherRepository extends JpaRepository<Teachers,Integer>{

}
