package com.greatlearning.library.springbootlibrarydesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.springbootlibrarydesign.model.GreatLearning;
import com.greatlearning.library.springbootlibrarydesign.service.ExampleService;

//@Controller
@RestController
public class TestController {
	
	@Autowired
	ExampleService testService;
	
	@GetMapping("/info")
	//@ResponseBody
	public GreatLearning get() {
//		GreatLearning greatLearning = new GreatLearning();
//		greatLearning.setCourseName("Learning Controllers using Spring-boot");
//		greatLearning.setCourseType("IT");
//		greatLearning.setInstructorName("Samarth Narula");
		return testService.get();
		}
	
	@PostMapping("customInfo")
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
//		GreatLearning greatLearning = new GreatLearning();
//		greatLearning.setCourseName(courseName);
//		greatLearning.setCourseType(courseType);
//		greatLearning.setInstructorName(instructorName);
		
		return testService.customInfo(courseName, courseType, firstName, lastName);
	}
	

}
