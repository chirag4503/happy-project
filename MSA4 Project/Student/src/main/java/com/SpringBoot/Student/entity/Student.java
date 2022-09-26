package com.SpringBoot.Student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rollNo;
	
	private String name;
	private String gender;
	private int age;
	private long college_id;
	public Student(String name, String gender, int age,  long college_id) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.college_id = college_id;
	}
	
	
}