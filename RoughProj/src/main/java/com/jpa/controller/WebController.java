package com.jpa.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jpa.DTO.StudentDTO;
import com.jpa.Service.CourseService;
import com.jpa.Service.StudentService;
import com.jpa.model.Courses;
import com.jpa.model.Student;

@Controller
public class WebController {
	@Autowired
	UserDetailsService userdetailsService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired 
	private CourseService service;
	
@GetMapping("/registration")
public String getRegistrationPage(@ModelAttribute("student") StudentDTO studentDTO) {
	return "NewStudent";
}


@GetMapping("/profile/{id}")
public String getStudentProfile(@PathVariable(value="id") int id,Model model) {
	//get Student from the service
	Student student=studentService.getStudentById(id);
	model.addAttribute("student",student);
	return "UpdateStudent";
	
}
@PostMapping("/Updation")
public String saveUpStudent(@ModelAttribute("student") StudentDTO studentDTO,Model model ) {
    studentService.save(studentDTO);
	model.addAttribute("message","Registered Susscessfully");
	return "index";
}

@PostMapping("/registration")
public String saveStudent(@ModelAttribute("student") StudentDTO studentDTO,Model model ) {
	studentService.save(studentDTO);
	model.addAttribute("message","Registered Susscessfully");
	return "login";
}

@GetMapping("/login")
public String login() {
	return "login";
}

@GetMapping("/user-page")
public String studentHomePage(Model model, Principal principal) {
	UserDetails userdetails=userdetailsService.loadUserByUsername(principal.getName());
	model.addAttribute("admin", userdetails);
	model.addAttribute("ListOfCourse",service.getAllCourses());

	return "index";
}
@GetMapping("/admin-page")
public String adminHomePage(Model model, Principal principal) {
	UserDetails userdetails=userdetailsService.loadUserByUsername(principal.getName());
	model.addAttribute("admin", userdetails);
	model.addAttribute("ListOfCourse",service.getAllCourses());
	return "admin";
}

@GetMapping("/listMyCourse")
public String viewListOfCourseAtUserPage(Model model) {
	model.addAttribute("ListOfCourses",service.getAllCourses());
	return "MyCourses";
}


//Courses Mapping for Admin...................................................................................
@GetMapping("/Home")
public String viewListOfCourse(Model model) {
	model.addAttribute("ListOfCourse",service.getAllCourses());
	return "DisplayCourse";
}

@GetMapping("/showNewCourseForm")
public String showNewcourse(Model model) {
	Courses courses=new Courses();
	model.addAttribute("courses",courses);
	return "AddCourse";
}
@PostMapping("/saveCourse")
public String saveStudents(@ModelAttribute("courses") Courses courses,Model model){
	//Save New Course
service.saveCourses(courses);
model.addAttribute("ListOfCourse",service.getAllCourses());
return "DisplayCourse";
}
@GetMapping("/showUpdateForm/{id}")
public String showUpdateForm(@PathVariable(value="id") long id,Model model) {
	//get Student from the service
	Courses courses=service.getCourseById(id);
	model.addAttribute("courses",courses);
	return "UpdateCourse";
	
}
@GetMapping("/deleteCourse/{id}")
public String deleteCourse(@PathVariable(value="id") long id) {
	this.service.deleteCourse(id);
	return "redirect:/Home";
}
}
