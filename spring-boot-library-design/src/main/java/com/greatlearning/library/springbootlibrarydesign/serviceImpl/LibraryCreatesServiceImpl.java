package com.greatlearning.library.springbootlibrarydesign.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.library.springbootlibrarydesign.entity.Library;
import com.greatlearning.library.springbootlibrarydesign.respository.LibraryRepository;
import com.greatlearning.library.springbootlibrarydesign.service.LibraryCreateService;

@Service
public class LibraryCreatesServiceImpl implements LibraryCreateService {

	@Autowired
	LibraryRepository libraryRepository;

	@Override
	public String addSingleLibrary(Library library) {
		libraryRepository.save(library);
		libraryRepository.flush();
		return "library saved";
	}

	@Override
	public String addAllLibraries(List<Library> libraries) {
		libraryRepository.saveAll(libraries);
		libraryRepository.flush();
		return "All libraries are saved";
	}

	@Override
	public Library addLibraryWithSaveAndFlush(Library library) {
		return libraryRepository.saveAndFlush(library);
	}

}
