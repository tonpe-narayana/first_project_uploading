package com.tonpe.springrest.services;

import java.util.List;

import com.tonpe.springrest.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();
	public Course getCoursesById(Long cid);
	public Course addCourses(Course  course);
	public Course updateCourse(Course  course);
	
	public void deleteById(Long cid);
	

}
