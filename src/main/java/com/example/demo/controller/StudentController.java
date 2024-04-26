package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;



@RestController
public class StudentController {
	
	@Autowired
	StudentService servi;
	
	
	@PostMapping("/AddStudent")
	public Student addStudent(Student student) {
		return servi.saveStudent(student);
	}
	
	
	@PostMapping("/AddStudents")
	public List<Student> addStudents(List<Student>student) {
		return servi.saveStudents(student);
	}
	
	
	@GetMapping("/FindStudent")
    public List<Student>FindAllStudents(){
		return servi.getAllStudents();
    }
	
	
	@GetMapping("/FindStudent/{id}")
	public Student FindStudentById(int id) {
		return servi.getStudentById(id);
	}
	
	
	@DeleteMapping
	public String DeleteStudent(int id) {
		servi.deleteStudent(id);
		return "product removed || "+id; 
	}
	
	
	@PutMapping("/UpdateStudent")
	public Student UpdateStudent(Student student)
	{
		return servi.updateStudent(student);
	}
	
}
