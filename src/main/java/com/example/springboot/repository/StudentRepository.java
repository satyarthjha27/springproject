package com.example.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.model.Students;

public interface StudentRepository extends JpaRepository<Students,Integer>{

}
