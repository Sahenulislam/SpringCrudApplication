package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	
	public String deleteStudent(int id) {
		repo.deleteById(id);
		return "product removed || "+id; 
	}
	
	
	public Student updateStudent(Student student)
	{
		Student existingStudent=repo.findById(student.getStudentId()).orElse(null);
		existingStudent.setStudentName(student.getStudentName());
		existingStudent.setStudentIntake(student.getStudentIntake());
		existingStudent.setStudentSection(student.getStudentSection());
        return repo.save(existingStudent);
	}

	
}
