package com.SpringBoot.Student.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class College {
	
	 @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int totalStudents;
	
	public College(String name, int totalStudents) {
		super();
		this.name = name;
		this.totalStudents = totalStudents;
	}
	
}
