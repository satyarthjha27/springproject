package com.example.springboot.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="Teacher_Table")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Teachers implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	private String name;
	
	@OneToMany
	private Set<Students> student;
	
	
	public Set<Students> getStudent() {
		return student;
	}
	public void setStudent(Students student) {
		this.student.add(student);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Teachers(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Teachers() {

	}
	
	

}
