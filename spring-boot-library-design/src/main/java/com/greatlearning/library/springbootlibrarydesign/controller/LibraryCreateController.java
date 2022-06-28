package com.greatlearning.library.springbootlibrarydesign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.library.springbootlibrarydesign.entity.Library;
import com.greatlearning.library.springbootlibrarydesign.service.LibraryCreateService;

@RestController	
@RequestMapping("/createService")
public class LibraryCreateController {
	
	@Autowired
	LibraryCreateService createService;
	
	@PostMapping("/addSingleLibrary")
	public String addSingleLibrary(Library library) {
	return createService.addSingleLibrary(library);
	}
	
	@PostMapping("/insertAllLibraries")
	public String insertallLibraries(@RequestBody List<Library> libraries) {
		return createService.addAllLibraries(libraries);
	}
	
	@PostMapping("/addLibraryWithSaveAndflush")
	public Library addLibraryWithSaveAndflush(Library library) {
		return createService.addLibraryWithSaveAndFlush(library);
	}
}
