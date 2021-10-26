package com.tonpe.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonpe.springrest.dao.CourseDao;
import com.tonpe.springrest.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao coursedao;
	
	// List<Course> list;
	

	public CourseServiceImpl() {
		/*
		list = new ArrayList<Course>();
		list.add(new Course(1001,"java","wonderful ook"));
		list.add(new Course(2002,"python ","easy one"));
		*/

	}


	@Override
	public List<Course> getCourses() {
		return coursedao.findAll();
	}


	@Override
	public Course getCoursesById(Long cid) {
		/*
		Course c = null;
		for (Course course : list) {
			if(course.getCourseId() == cid) {
				c = course;
				break;
			}
			
		}
		*/
		
		return coursedao.findById(cid).orElse(null);
	}


	@Override
	public Course addCourses(Course course) {
		//list.add(course);
		coursedao.save(course);
		return course;
	}


	@Override
	public Course updateCourse(Course course) {
		/*
		list.forEach(e->{
			if(e.getCourseId() == course.getCourseId())
			{
					e.setCourseName(course.getCourseName());
					e.setCourseDesc(course.getCourseDesc());
			}
		}
		);
		*/
		coursedao.save(course);

		return course;
	}


	
	@Override
	public void deleteById(Long cid) {
		//list = this.list.stream().filter(e->e.getCourseId() != cid).collect(Collectors.toList());
		
		Course entity = coursedao.getOne(cid);
		coursedao.delete(entity);
		
	}

}
