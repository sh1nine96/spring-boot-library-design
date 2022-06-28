package com.greatlearning.library.springbootlibrarydesign.service;

import java.util.List;

import com.greatlearning.library.springbootlibrarydesign.entity.Library;

public interface LibraryCreateService {

	String addSingleLibrary(Library library);

	String addAllLibraries(List<Library> libraries);

	Library addLibraryWithSaveAndFlush(Library library);

}