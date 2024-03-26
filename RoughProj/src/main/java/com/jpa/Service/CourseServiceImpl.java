package com.jpa.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.model.Courses;
import com.jpa.repo.CoursesRepo;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CoursesRepo courepo;
		@Override
		public List <Courses> getAllCourses() {
			return courepo.findAll();
		}

		@Override
		public void saveCourses(Courses courses) {
		this.courepo.save(courses);
			
		}

		@Override
		public Courses getCourseById(long id) {
		Optional<Courses> option=courepo.findById(id);
		Courses courses=null;
		if(option.isPresent()) {
			courses=option.get();
			}else {
				throw new RuntimeException("Student Not Found : "+id);
			}
			return courses;
		}

		@Override
		public void deleteCourse(long id) {
			this.courepo.deleteById(id);
		}

}
