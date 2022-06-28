package com.greatlearning.library.springbootlibrarydesign.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.greatlearning.library.springbootlibrarydesign.entity.Library;
import com.greatlearning.library.springbootlibrarydesign.respository.LibraryRepository;
import com.greatlearning.library.springbootlibrarydesign.service.LibraryCountService;

@Service
public class LibraryCountServiceImpl implements LibraryCountService {
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public long countLibraries() {
		return libraryRepository.count();
	}
	
	@Override
	public long countLibrariesWithZeroBooks() {

		Library library = new Library();
		library.setCommaSeparatedBookNames("");
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(library, exampleMatcher);
		return libraryRepository.count(example);
	}

}
