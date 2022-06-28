package com.greatlearning.library.springbootlibrarydesign.service;

import org.springframework.stereotype.Component;

import com.greatlearning.library.springbootlibrarydesign.model.GreatLearning;


@Component
public interface ExampleService {

	GreatLearning get();

	GreatLearning customInfo(String courseName, String courseType, String firstName, String lastName);

}