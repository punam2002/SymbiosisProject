package com.jpa.Service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jpa.model.Student;

public class CustomUserDetails implements UserDetails {
	private Student student;
	public CustomUserDetails(Student student) {
		this.student = student;
	}
 public String getfullName() {
	 return student.getStudent_Name();
 }
 public int getUserId() {
	 return student.getStudentId();
 }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return List.of(() ->student.getRole() );
	}

	@Override
	public String getPassword() {
		
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		
		return student.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
