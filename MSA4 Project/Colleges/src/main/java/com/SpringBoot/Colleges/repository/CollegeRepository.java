package com.SpringBoot.Colleges.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.Colleges.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
	
	College findById(long id);
	
}
