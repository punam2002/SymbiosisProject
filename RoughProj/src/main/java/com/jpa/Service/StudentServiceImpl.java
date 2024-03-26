package com.jpa.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jpa.DTO.StudentDTO;
import com.jpa.model.Student;
import com.jpa.repo.StudentRepo;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
     private StudentRepo studentRepo;
	@Override
	public Student save(StudentDTO studentDTO) {
		Student student=new Student(
				studentDTO.getStudent_Name(),
				studentDTO.getCity(),
				studentDTO.getContact(),
				studentDTO.getDate(),
				studentDTO.getEmail(),
				studentDTO.getInstitute(),
				passwordEncoder.encode(studentDTO.getPassword()),
				studentDTO.getRole()
				);
		return  studentRepo.save(student);
	}
	@Override
	public Student getStudentById(int id) {
		Optional<Student> option=studentRepo.findById(id);
		Student student=null;
		if(option.isPresent()) {
			student=option.get();
			}else {
				throw new RuntimeException("Student Not Found : "+id);
			}
			return student;
	}

}
