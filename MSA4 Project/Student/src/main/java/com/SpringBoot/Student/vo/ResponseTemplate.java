package com.SpringBoot.Student.vo;


import com.SpringBoot.Student.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplate {
	
	private Student student;
	private College college;


}
