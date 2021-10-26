package com.tonpe.springrest.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tonpe.springrest.entities.Course;
import com.tonpe.springrest.services.CourseService;

@RestController
public class MyController {

	@Autowired
	private CourseService cs;

	@GetMapping("/home")
	public String home() {
		return "this is my first rest app";
	}

	// get all course detail
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return this.cs.getCourses();
	}

	// get courses by id
	@GetMapping("/courses/{cid}")
	public Course getCoursesById(@PathVariable String cid) {
		return this.cs.getCoursesById(Long.parseLong(cid));
	}

	// add courses
	@PostMapping("/courses")
	public Course addCourses(@RequestBody Course course) {
		return this.cs.addCourses(course);
	}

	// udate courses
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.cs.updateCourse(course);
	}

	// delete
	@DeleteMapping("/courses/{cid}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable String cid) {
		try {
			 this.cs.deleteById(Long.parseLong(cid));
			return new ResponseEntity<>(HttpStatus.OK);

		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
