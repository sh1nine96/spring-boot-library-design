package com.greatlearning.library.springbootlibrarydesign.serviceImpl;

import org.springframework.stereotype.Service;

import com.greatlearning.library.springbootlibrarydesign.model.FullName;
import com.greatlearning.library.springbootlibrarydesign.model.GreatLearning;
import com.greatlearning.library.springbootlibrarydesign.service.ExampleService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExampleServiceImpl implements ExampleService {
	
	@Override
	public GreatLearning get() {
		log.info("Inside get() method");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName("Learning Controllers using Spring-boot");
		greatLearning.setCourseType("IT");
		greatLearning.setInstructorName(FullName.builder().firstName("Samarth").lastName("Narula").build());
		//greatLearning.setInstructorName("Samarth Narula");
		return greatLearning;
		}
	
	@Override
	public GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName) {
		log.info("Inside customInfo() method");
		GreatLearning greatLearning = new GreatLearning();
		greatLearning.setCourseName(courseName);
		greatLearning.setCourseType(courseType);
		greatLearning.setInstructorName
		(FullName.builder().firstName("Samarth").lastName("Narula").build());
	//	greatLearning.setInstructorName(instructorName);
		return greatLearning;
	}

}
