package com.jpa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jpa.model.Student;
import com.jpa.repo.StudentRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {
     @Autowired
	private StudentRepo studentRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  Student student=studentRepo.findByEmail(username);
	  if(student==null) {
		  throw new UsernameNotFoundException("Student Not Found");
	  }
	  
		return new CustomUserDetails(student);
	}

}
