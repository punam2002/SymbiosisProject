package com.jpa.Service;

import java.util.List;

import com.jpa.model.Courses;
import com.jpa.model.Student;

public interface CourseService {
	List <Courses> getAllCourses();
	void saveCourses(Courses student);
	Courses getCourseById(long id);
	void deleteCourse(long id);

}
