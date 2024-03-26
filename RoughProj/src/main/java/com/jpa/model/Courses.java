package com.jpa.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="courses")
public class Courses {
	 public Courses() {
		super();
	}

	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long courseId;
	    private String Coursename;
	    private String CourseLink;
	    private String CourseDoc;

	    @ManyToMany(mappedBy = "courses")
	    private Set<Student> students = new HashSet<>();

		public Long getCourseId() {
			return courseId;
		}

		public void setCourseId(Long courseId) {
			this.courseId = courseId;
		}

		public String getCoursename() {
			return Coursename;
		}

		public void setCoursename(String coursename) {
			Coursename = coursename;
		}

		public String getCourseLink() {
			return CourseLink;
		}

		public void setCourseLink(String courseLink) {
			CourseLink = courseLink;
		}

		public String getCourseDoc() {
			return CourseDoc;
		}

		public void setCourseDoc(String courseDoc) {
			CourseDoc = courseDoc;
		}

		public Set<Student> getStudents() {
			return students;
		}

		public void setStudents(Set<Student> students) {
			this.students = students;
		}
}
