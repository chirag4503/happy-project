package com.SpringBoot.Colleges.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot.Colleges.entity.College;
import com.SpringBoot.Colleges.vo.RequestTemplate;

@Service
public interface CollegeService {
	
	College add(College college);
	List<College> list();
	College update(long id,String name);
	College searchById(long id);
	List<RequestTemplate> listWithStudent();
	RequestTemplate specificCollegeStudent(long college_id);
	

}
