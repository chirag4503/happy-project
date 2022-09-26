package com.SpringBoot.Colleges.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Colleges.entity.College;
import com.SpringBoot.Colleges.service.CollegeService;
import com.SpringBoot.Colleges.vo.RequestTemplate;

@RestController
@RequestMapping("/college")
public class CollegeController {
	
		@Autowired
	 	CollegeService collegeService;
		
		@PostMapping
		public College add(@RequestBody College college){
			return collegeService.add(college);
		}

		@GetMapping
		public List<College> list(){
			return collegeService.list();
		}

		@GetMapping("/{id}")
		public College searchById(@PathVariable long id) {
			return collegeService.searchById(id);
		}

		@GetMapping("/all-college-student")
		public List<RequestTemplate> listWithStudent() {
			return collegeService.listWithStudent();
		}

		@GetMapping("/college-with-student/{college_id}")
		public RequestTemplate specificCollegeStudent(@PathVariable long college_id) {
			return collegeService.specificCollegeStudent(college_id);
		}
	 

}
