package com.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.model.Courses;

public interface CoursesRepo extends JpaRepository<Courses, Long> {

}