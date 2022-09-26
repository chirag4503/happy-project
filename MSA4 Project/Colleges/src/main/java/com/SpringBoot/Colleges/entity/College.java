package com.SpringBoot.Colleges.entity;

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
