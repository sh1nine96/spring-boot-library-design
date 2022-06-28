package com.greatlearning.library.springbootlibrarydesign.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.library.springbootlibrarydesign.entity.Library;
import com.greatlearning.library.springbootlibrarydesign.respository.LibraryRepository;
import com.greatlearning.library.springbootlibrarydesign.service.LibraryReadService;

@Service
public class LibraryReadServiceImpl implements LibraryReadService {

	@Autowired
	LibraryRepository readRepository;

	@Override
	public List<Library> getAllLibrary() {
		return readRepository.findAll();
	}

	@Override
	public List<Library> getAllLibrariesWithNoBooks() {
		Library libraryWithNoBooks = new Library();
		libraryWithNoBooks.setCommaSeparatedBookNames("");

		// System.out.println("just to show how it looks like "+ libraryWithNoBooks);

// Below Example matcher will only consider commaSeparatedBookNames and igonre id and name

		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");

		Example<Library> example = Example.of(libraryWithNoBooks, exampleMatcher);

		return readRepository.findAll(example);

	}

	@Override
	public Page<Library> getLibrariesPaged() {

		Pageable first3records = PageRequest.of(1, 3);
		return readRepository.findAll(first3records);
	}

	@Override
	public Page<Library> getLibrariesCustomPaged(int pageNumber, int noOfRecordsOnPage) {
		Pageable first3Records = PageRequest.of(pageNumber, noOfRecordsOnPage);
		return readRepository.findAll(first3Records);
	}

	@Override
	public List<Library> getLibrariesWithLatestAddedOrder() {
		return readRepository.findAll(Sort.by(Direction.DESC, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedById(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "id"));
	}

	@Override
	public List<Library> getLibrariesCustomSortedByName(Direction direction) {
		return readRepository.findAll(Sort.by(direction, "name"));
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable first3records = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(example, first3records);
	}

	@Override
	public Page<Library> getLibrariesPagedAndSortedByName() {
		Pageable pageable = PageRequest.of(0, 2, Sort.by("name"));
		return readRepository.findAll(pageable);
	}

	@Override
	public Page<Library> getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks(String commaSeparatedBookNames,
			int pageNumber, int numberOfRecordsOnPage) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher("commaSeparatedBookNames", ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example <Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		Pageable customPage = PageRequest.of(pageNumber, numberOfRecordsOnPage, Sort.by("name"));
		return readRepository.findAll(example, customPage);
    }
	@Override
	public List<Library> getSortedByNameAndWithTheseBooks(String commaSeparatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher(commaSeparatedBookNames, ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example <Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findAll(example, Sort.by("name"));
	}
	
	@Override
	public List<Library> getLibrariesByIds(List <Long> ids) {
		return readRepository.findAllById(ids);
	}
	
	@Override
	public Optional<Library> getALibraryById(Long id) {
		return readRepository.findById(id);
	}

	
	@Override
	public Optional<Library> getALibraryWithTheseBooks(String commaSeparatedBookNames) {
		Library libraryWithTheseBooks = new Library();
		libraryWithTheseBooks.setCommaSeparatedBookNames(commaSeparatedBookNames);
		ExampleMatcher exampleMatcher = ExampleMatcher.matching()
				.withMatcher(commaSeparatedBookNames, ExampleMatcher.GenericPropertyMatchers.exact())
				.withIgnorePaths("id", "name");
		Example<Library> example = Example.of(libraryWithTheseBooks, exampleMatcher);
		return readRepository.findOne(example);
	}
}
