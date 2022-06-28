package com.greatlearning.library.springbootlibrarydesign.service;

public interface LibraryExistService {

	boolean checkLibraryExistsById(Long id);

	boolean checkLibraryExistsByExample(String commaSeparatedBookNames);

}