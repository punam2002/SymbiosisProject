package com.jpa.DTO;



//DTO ----> Data Transfer Object....

public class StudentDTO {
	public StudentDTO(String student_Name, 
			String city, String contact, 
			String date,String email, 
			String institute,String password,
			String role) {
		super();
		Student_Name = student_Name;
		this.city = city;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.institute = institute;
		this.date = date;
		this.role = role;
	}
	private String Student_Name;
	private String city;
	private String contact;
	private String email;
	private String password;
	private String institute;
	private String date;
	private String role;
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
