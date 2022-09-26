package com.SpringBoot.Colleges.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.SpringBoot.Colleges.entity.College;
import com.SpringBoot.Colleges.repository.CollegeRepository;
import com.SpringBoot.Colleges.service.CollegeService;
import com.SpringBoot.Colleges.vo.RequestTemplate;
import com.SpringBoot.Colleges.vo.Student;

@Component
public class CollegeImplementation implements CollegeService {
	
	
	@Autowired
	CollegeRepository colgRepo;
	@Autowired
	RestTemplate restTemplate;

	@Override
	
	public College add(College college) {
		return colgRepo.save(college);
	}

	@Override
	public List<College> list() {
		return colgRepo.findAll();
	}

	@Override
	public College update(long id, String name) {
		College college = colgRepo.findById(id);
		college.setName(name);
		return colgRepo.save(college);
		
	}

	@Override
	public College searchById(long id) {
		if (colgRepo.findById(id) == null) {
			return null;
		}
		return colgRepo.findById(id);
	}

	@Override
	public List<RequestTemplate> listWithStudent() {
		List<RequestTemplate> fullList = new ArrayList<RequestTemplate>();
		List<College> allCollege = this.list();
		Iterator<College> ir = allCollege.iterator();
		while (ir.hasNext()) {
			College clg = ir.next();
			ResponseEntity<Student[]> response = restTemplate.getForEntity(
					"http://STUDENT-SERVICE/student/student-with-ascname/" + clg.getId(), Student[].class);
			Student[] colleges = response.getBody();
			List<Student> std = Arrays.asList(colleges);
			RequestTemplate RTm = new RequestTemplate();
			RTm.setCollege(clg);
			RTm.setStudentList(std);
			fullList.add(RTm);
		}
		return fullList;
	}

	@Override
	public RequestTemplate specificCollegeStudent(long college_id) {
		College college = this.searchById(college_id);

		ResponseEntity<Student[]> response = restTemplate.getForEntity(
				"http://STUDENT-SERVICE/student/student-with-desc-age/" + college.getId(), Student[].class);
		Student[] student = response.getBody();
		List<Student> students = Arrays.asList(student);
		RequestTemplate requestTemplate = new RequestTemplate();

		requestTemplate.setCollege(college);
		requestTemplate.setStudentList(students);

		return requestTemplate;
	}
}
