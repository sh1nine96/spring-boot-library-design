package com.greatlearning.library.springbootlibrarydesign.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.library.springbootlibrarydesign.entity.Library;
import com.greatlearning.library.springbootlibrarydesign.respository.LibraryRepository;
import com.greatlearning.library.springbootlibrarydesign.service.LibraryDeleteService;

@Service
public class LibraryDeleteServiceImpl implements LibraryDeleteService {
	
	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public String deleteOneLibrary(Library library) {
		libraryRepository.delete(library);
		return "Deleted Library: " + library;
	}
	
	@Override
	public String pruneTable() {
		libraryRepository.deleteAll();
		return "prune/truncate completed";
	}
	
	@Override
	public String deleteAllThese(List<Library> libraries) {
		libraryRepository.deleteAll(libraries);
		return "delete all completed";
	}
	
	@Override
	public String deletAllInbatch() {
		libraryRepository.deleteAllInBatch();
		return "Deleted All in batch completed";
	}
	
	@Override
	public String deleteLibraryById(Long id) {
		libraryRepository.deleteById(id);
		return "Library with this: "+id+" is deleted";
	}
	
	@Override
	public String deleteAllTheseInBatch(List<Library> libraries) {
		libraryRepository.deleteInBatch(libraries);
		return "Deleted All Libraries from list in batch mode";
		
	}

}
