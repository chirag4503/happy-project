package com.SpringBoot.Colleges.vo;

import java.util.ArrayList;
import java.util.List;

import com.SpringBoot.Colleges.entity.College;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestTemplate {
	
	private College college;

	private List<Student> studentList = new ArrayList<Student>();
	


	
}