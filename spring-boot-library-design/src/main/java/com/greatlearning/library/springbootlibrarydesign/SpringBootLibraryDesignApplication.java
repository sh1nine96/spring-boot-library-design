package com.greatlearning.library.springbootlibrarydesign;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.library.springbootlibrarydesign.entity.Library;
import com.greatlearning.library.springbootlibrarydesign.model.FullName;
import com.greatlearning.library.springbootlibrarydesign.model.GreatLearning;
import com.greatlearning.library.springbootlibrarydesign.service.LibraryCountService;
import com.greatlearning.library.springbootlibrarydesign.service.LibraryCreateService;
import com.greatlearning.library.springbootlibrarydesign.service.LibraryDeleteService;
import com.greatlearning.library.springbootlibrarydesign.service.LibraryExistService;
import com.greatlearning.library.springbootlibrarydesign.service.LibraryReadService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringBootLibraryDesignApplication implements CommandLineRunner {

	@Autowired
	LibraryReadService libraryReadServiceImpl;

	@Autowired
	LibraryCreateService libraryCreatesServiceImpl;

	@Autowired
	LibraryCountService countServiceImpl;

	@Autowired
	LibraryExistService existServiceImpl;

	@Autowired
	LibraryDeleteService deleteServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLibraryDesignApplication.class, args);
		System.out.println("Hi Spring boot");
	}

	@Override
	public void run(String... args) throws Exception {
//		readServiceImplMethodsExecution();
//      createServiceImplMethodsExecution();
//		countServiceImplMethodsExecution();
//		existServiceImplMethodsImplementation();

//		log.info("Deleted one library->{}", deleteServiceImpl.deleteOneLibrary(
//				Library.builder().id(10l).commaSeparatedBookNames("xyz, abc, def").name("C Library").build()));	
//		log.info("Prune Library Table->{}", deleteServiceImpl.pruneTable());
		
//		List<Library> libraries = new ArrayList<Library>();
//		libraries.add(Library.builder().id(3l).commaSeparatedBookNames("").name("Animal Library").build());
//		libraries.add(Library.builder().id(4l).commaSeparatedBookNames("").name("Plant Library").build());
//		log.info("Delete All These->{}", deleteServiceImpl.deleteAllThese(libraries));
		
//		log.info("Delete all in batch->{}", deleteServiceImpl.deletAllInbatch());
		
//		log.info("Delete Library by id->{}", deleteServiceImpl.deleteLibraryById(6l));
		
//		List<Library> libraries = new ArrayList<Library>();
//		libraries.add(Library.builder().id(3l).commaSeparatedBookNames("").name("Animal Library").build());
//		libraries.add(Library.builder().id(4l).commaSeparatedBookNames("").name("Plant Library").build());
//		log.info("Deleted all these libraries in batch->{}", deleteServiceImpl.deleteAllTheseInBatch(libraries));
	}

	private void existServiceImplMethodsImplementation() {
		log.info("check if library exists by ID->{}", existServiceImpl.checkLibraryExistsById(2l));

		log.info("check if library exists by example->{}",
				existServiceImpl.checkLibraryExistsByExample("Yellow Sun, Blue Star, Red Star"));
		
	}

	private void countServiceImplMethodsExecution() {
		log.info("Count the number of libraries->{}", countServiceImpl.countLibraries());

		log.info("count libraries with zero books->{}", countServiceImpl.countLibrariesWithZeroBooks());
	}

	private void createServiceImplMethodsExecution() {
		log.info("Persist a single library->{}", libraryCreatesServiceImpl.addSingleLibrary(
				Library.builder().id(11l).name("E Library").commaSeparatedBookNames("xyz, abc").build()));

		List<Library> libraries = new ArrayList<>();
		libraries.add(Library.builder().id(12l).name("F Library").commaSeparatedBookNames("abc, def").build());
		libraries.add(Library.builder().id(13l).name("G Library").commaSeparatedBookNames("def").build());
		log.info("Persist all Libraries->{}", libraryCreatesServiceImpl.addAllLibraries(libraries));

		log.info("Persist libarary with saveAndFlush Combined->{}",
				libraryCreatesServiceImpl.addLibraryWithSaveAndFlush(Library.builder().id(14l)
						.name("E- commerce Library").commaSeparatedBookNames("Amazon, Flipkart ").build()));
	}

	private void readServiceImplMethodsExecution() {
		log.info("Fetch all libraries -> {}", libraryReadServiceImpl.getAllLibrary());

		libraryReadServiceImpl.getAllLibrariesWithNoBooks();

		log.info("Fetch All libraries with no books -> {} ", libraryReadServiceImpl.getAllLibrariesWithNoBooks());

//		Page<Library> page = libraryReadServiceImpl.getLibrariesPaged();
//		List<Library> libraries = page.get().collect(Collectors.toList());
//		log.info("Fetch libraries in Page format-> {}", libraries);

		// we can print above result as follows
		log.info("Fetch libraries in Page format-> {}",
				libraryReadServiceImpl.getLibrariesPaged().get().collect(Collectors.toList()));

		log.info("Fetch libraries in custom page format->{} ",
				libraryReadServiceImpl.getLibrariesCustomPaged(2, 2).get().collect(Collectors.toList()));

		log.info("Fetch libraries with latest added order->{}",
				libraryReadServiceImpl.getLibrariesWithLatestAddedOrder());

		log.info("Fetch libraries in custom order by ID->{} ",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.ASC));

		log.info("Fetch libraries in custom order by ID->{} ",
				libraryReadServiceImpl.getLibrariesCustomSortedById(Direction.DESC));
		log.info("Fetch libraies in custom order by name->{} ",
				libraryReadServiceImpl.getLibrariesCustomSortedByName(Direction.DESC));

		log.info("Fetch libraries deafault paged, sorted and with these books ->{} ", libraryReadServiceImpl
				.getLibrariesPagedAndSortedByNameAndWithTheseBooks("xyz, abc, def").get().collect(Collectors.toList()));

		log.info("Fetch libraries default paged & default sorted by name->{} ",
				libraryReadServiceImpl.getLibrariesPagedAndSortedByName().get().collect(Collectors.toList()));

		log.info("Fetch libraries custom paged & Default sorted by name & with these books->{}",
				libraryReadServiceImpl
						.getLibrariesCustomPagedAndSortedWithDefaultOrderByNameAndWithTheseBooks("xyz, abc, def", 1, 2)
						.get().collect(Collectors.toList()));

		log.info("fetch libraries with default sorted by name->{}",
				libraryReadServiceImpl.getSortedByNameAndWithTheseBooks("xyz, abc, def"));

		List<Long> ids = new ArrayList<Long>();
		ids.add(1l);
		ids.add(2l);
		ids.add(3l);
		log.info("fetch libraries by id->{}", libraryReadServiceImpl.getLibrariesByIds(ids));

		Long id = 2l;
		Optional<Library> optionalLibrary = libraryReadServiceImpl.getALibraryById(id);
		if (optionalLibrary.isPresent()) {
			log.info("fetch library by id ->{}", optionalLibrary.get());
		} else {
			log.info("No matching library found with this id: " + id + " in the database ");
		}

		Optional<Library> optionalSingleLibrary = libraryReadServiceImpl
				.getALibraryWithTheseBooks("Life of Tommy, Life of Brownie");
		if (optionalSingleLibrary.isPresent()) {
			log.info("fetch library with these books->{}", optionalSingleLibrary.get());
		} else {
			log.info("No matching library found with this id: " + id + " in the database ");
		}
	}

//	GreatLearning greatLearning = new GreatLearning();
//	greatLearning.setCourseName("Designing Microservices using Spring-boot");
//	greatLearning.setCourseType("Information Technology");
//	greatLearning.setInstructorName("Samarth Narula");
//
//	System.out.println("Great Learning object" + greatLearning);
//	System.out.println("Get method for CourseName: " + greatLearning.getCourseName());
//	System.out.println("Get method for CourseType: " + greatLearning.getCourseType());
//	System.out.println("Get method for InstructorName: " + greatLearning.getInstructorName());

//	GreatLearning greatLearning = new GreatLearning("Designing Microservices using Spring-boot",
//			"Information Technology", "Samarth Narula");
//	System.out.println("Great Learning object created using all args constructor: " + greatLearning);

//	GreatLearning greatLearning = new GreatLearning();
//	greatLearning.setCourseName(" Designing Microservices using Spring-boot");
//	greatLearning.setCourseType(" Information Technology");
//	greatLearning.setInstructorName(" Samarth Narula");

//	System.out.println("Get method for CourseName: " + greatLearning.getCourseName());
//	System.out.println("Get method for CourseType: " + greatLearning.getCourseType());
//	System.out.println("Get method for InstructorName: " + greatLearning.getInstructorName());

//	GreatLearning greatLearning = new GreatLearning("Designing Microservices using Spring-boot",
//			"Information Technology", "Samarth Narula");
//	System.out.println("Great Learning object : " + greatLearning);
//

	// Telescoping Design Pattern

//	GreatLearning greatLearningTeleDesignPattern = new GreatLearning("Learning Tele Design Pattern", "I T");
//	System.out.println("greatLearningTeleDesignPattern: " + greatLearningTeleDesignPattern);
//
//	// Builder Pattern
//
//	GreatLearning greatLearningWithBuilder = GreatLearning.builder().courseName("Learn Builder Pattern")
//			.courseType("Information Technology").instructorName("Samarth Narula").build();
//	System.out.println("Builder Design Pattern: " + greatLearningWithBuilder);
//	
//	GreatLearning greatLearningWithBuilder1 = GreatLearning.builder().courseName("Learn Builder Pattern")
//			.courseType("Information Technology").build();
//	System.out.println("Builder Design Pattern: " + greatLearningWithBuilder1);
//	
//	//only course name using builder
//	GreatLearning greatLearningOnlyCourseName = GreatLearning.builder()
//			.courseName("Benifit of Builder Pattern").build();
//	System.out.println("Builder Only Course Name: " + greatLearningOnlyCourseName);

	// Creating complex objets using builder method

//	GreatLearning greatLearningWithComplexObjects = GreatLearning.builder()
//					.courseName("Learning complex object with builder method")
//					.courseType("Information Technology")
//					.instructorName(FullName.builder()
//							.firstName("Samarth").lastName("Narula").build())
//					.build();
//	
////	System.out.println("complex objects creation using builder: "+greatLearningWithComplexObjects);
//
////using logger
//	log.info("complex objects creation using builder -> {} ", greatLearningWithComplexObjects);
}
