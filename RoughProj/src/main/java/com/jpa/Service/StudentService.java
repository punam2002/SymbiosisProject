package com.jpa.Service;

import com.jpa.DTO.StudentDTO;
import com.jpa.model.Student;

public interface StudentService {
 Student save(StudentDTO studentDTO);
 Student getStudentById(int id);
 
}
