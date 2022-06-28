package com.greatlearning.library.springbootlibrarydesign.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.library.springbootlibrarydesign.entity.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{

}
