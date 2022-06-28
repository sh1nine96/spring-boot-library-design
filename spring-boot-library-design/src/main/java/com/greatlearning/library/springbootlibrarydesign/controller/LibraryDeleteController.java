package com.greatlearning.library.springbootlibrarydesign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.springbootlibrarydesign.entity.Library;
import com.greatlearning.library.springbootlibrarydesign.service.LibraryDeleteService;

@RestController
@RequestMapping("/deleteService")
public class LibraryDeleteController {
	
	@Autowired
	LibraryDeleteService deleteService;
	
	@DeleteMapping
	public String deleteOneLibrary(Library library) {
		return deleteService.deleteOneLibrary(library);
	}

}
