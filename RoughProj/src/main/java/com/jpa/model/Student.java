package com.jpa.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="studentInfo", uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class Student {
	//insert into student_info (student_name,city,contact,date,email,institute,password,role,student_id)

public Student(String student_Name, String city, String contact, String date, String email,String institute, String password,
			 String role) {

		Student_Name = student_Name;
		this.city = city;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.institute = institute;
		this.date = date;
		this.role=role;
	}

public Student() {
		super();
	}

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="studentId")
private int studentId;

@Column(name="student_Name")
private String Student_Name;

@Column(name="city")
private String city;

@Column(name="contact")
private String contact;

@Column(name="email")
private String email;


@Column(name="password")
private String password;

@Column(name="institute")
private String institute;

@Column(name="date")
private String date;

@Column(name="role")
private String role;

@ManyToMany(cascade = { CascadeType.ALL })
@JoinTable(
        name = "student_course",
        joinColumns=@JoinColumn(name="studentId"),
		inverseJoinColumns=@JoinColumn(name="courseId")
		
)
private Set<Courses> courses = new HashSet<>();

public int getStudentId() {
	return studentId;
}

public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public String getStudent_Name() {
	return Student_Name;
}

public void setStudent_Name(String student_Name) {
	Student_Name = student_Name;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getInstitute() {
	return institute;
}

public void setInstitute(String institute) {
	this.institute = institute;
}

public String getDate() {
	return date;
}

public void setDate(String date) {
	this.date = date;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}
}
