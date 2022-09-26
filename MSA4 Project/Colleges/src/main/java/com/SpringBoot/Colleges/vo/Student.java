package com.SpringBoot.Colleges.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
	
	private long rollNo;
	private String name;
	private String gender;
	private int age;
	private String stream;
	private long college_id;
	
	public Student(String name, String gender, int age, String stream, long college_id) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.stream = stream;
		this.college_id = college_id;
	}
	

}
