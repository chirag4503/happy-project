package com.SpringBoot.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.Student.entity.Student;
import com.SpringBoot.Student.service.StudentService;
import com.SpringBoot.Student.vo.ResponseTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {	
	@Autowired
	StudentService stdService;
	@PostMapping
	public Student add(@RequestBody Student student) {
		return stdService.add(student);
	}
	@GetMapping
	public List<Student> listStd()  {
		return stdService.list();
	}
	@GetMapping("/{studentId}")
	public ResponseTemplate studentWithCollege(@PathVariable long studentId) {
		return stdService.studentWithCollege(studentId);
	}
	@PutMapping("/{studentId}/{collegeId}")
	public String updateCollege(@PathVariable long studentId, @PathVariable long collegeId) {
		Student std = stdService.assignCollege(studentId, collegeId);
		if (std != null) {
			return std.toString();
		}
		return "Sorry. College or Student Not Found";
	}

	@GetMapping("/student-with-ascname/{college_id}")
	public List<Student> getByColgtId(@PathVariable long college_id) {
		return stdService.getByColgtId(college_id);
	}

	@GetMapping("/student-with-desc-age/{college_id}")
	public List<Student> getStudentByCollegeWithDescAge(@PathVariable long college_id) {
		return stdService.getStudentByCollegeWithDescAge(college_id);
	}

}
