package com.greatlearning.library.springbootlibrarydesign.service;

import java.util.List;

import com.greatlearning.library.springbootlibrarydesign.entity.Library;

public interface LibraryDeleteService {

	String deleteOneLibrary(Library library);

	String pruneTable();

	String deleteAllThese(List<Library> libraries);

	String deletAllInbatch();

	String deleteLibraryById(Long id);

	String deleteAllTheseInBatch(List<Library> libraries);

}