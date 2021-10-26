package com.tonpe.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tonpe.springrest.entities.Course;

public interface CourseDao extends JpaRepository<Course, Long>
{
	

}
