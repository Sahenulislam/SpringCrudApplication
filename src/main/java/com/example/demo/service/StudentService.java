package com.example.demo.service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


import org.springframework.data.domain.Page;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
 
	@Autowired
	StudentRepository repo;
	
	public Student saveStudent(Student student) {
		return repo.save(student);
	}
	
	
	public List<Student> saveStudents(List<Student>student) {
		return repo.saveAll(student);
	}
	
	
	public List<Student>getAllStudents(){
		
		return repo.findAll(); 
    }
	
	
	public Student getStudentById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	
	public Page<Student> getStudentPagination(int page, int pagesize)
	{
		Pageable sortedByName = (Pageable) PageRequest.of(0, 3);
		return repo.findAll(sortedByName);
	}
	
	public String deleteStudent(int id) {
		repo.deleteById(id);
		return "product removed || "+id; 
	}
	
	public Student updateStudent(int id, Student newStudentData) {
	    // Find the existing student by ID
	    Optional<Student> optionalExistingStudent = repo.findById(id);
	    
	    // Check if the student exists in the database
	    if (optionalExistingStudent.isPresent()) {
	        Student existingStudent = optionalExistingStudent.get();
	        
	        // Update the existing student's data with the new data
	        existingStudent.setStudentName(newStudentData.getStudentName());
	        existingStudent.setStudentIntake(newStudentData.getStudentIntake());
	        existingStudent.setStudentSection(newStudentData.getStudentSection());
	        
	        // Save the updated student record in the database
	        return repo.save(existingStudent);
	    } else {
	        // Handle the case where the student with the given ID does not exist
	        // You might throw an exception, return null, or handle it in some other way
	        return null;
	    }
	}

	
}
