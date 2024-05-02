package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Nodes;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.client.RestTemplate;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/AddStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.save(student);
	}

	@PostMapping("/AddNodes")
	public Nodes addNodes(@RequestBody Nodes nodes) {
		return studentService.save(nodes);
	}

	@PostMapping("/AddStudents")
	public List<Student> addStudents(@RequestBody List<Student> student) {
		return studentService.saveAll(student);
	}

	@GetMapping("/FindStudents")
	public List<Student> FindAllStudents() {
		return studentService.findAll();
	}

	@GetMapping("/FindNodes")
	public List<Nodes> FindAllNodes() {
		return studentService.findAllNodes();
	}

	@GetMapping("/FindStudent/{id}")
	public Student FindStudentById(@PathVariable int id) {
		return studentService.findById(id);
	}

	@GetMapping("/FindStudentsPagination/{page}/{pagesize}")
	public Page<Student> FindStudentPagination(@PathVariable int page, @PathVariable int pagesize) {
		return studentService.findAll(page, pagesize);
	}

	@GetMapping("/FindAnwarCloudeNodes")
	public List<Nodes> FindAnwarCloudeNodes()  {
		
		return studentService.fetchAndSaveDataFromThirdPartyApi();
		

	}


	@GetMapping("/FindAllStudentBySection/{Section}")
	public List<Student> findAllStudentBySection(@PathVariable String Section) {
		return studentService.findAllBySection(Section);
	}

	@GetMapping("/FindAllStudentBySection/{section}/{page}/{pagesize}")
	public Page<Student> findAllStudentBySectionPaging(@PathVariable String section, @PathVariable int page,
			@PathVariable int pagesize) {
		return studentService.findAllBySectionPaging(section, page, pagesize);

	}

	@DeleteMapping("/DeleteStudent/{id}")
	public String DeleteStudent(@PathVariable int id) {
		studentService.deleteById(id);
		return "product removed || " + id;
	}

	@PutMapping("/UpdateStudent/{id}")
	public Student UpdateStudent(@PathVariable int id, @RequestBody Student student) {
		return studentService.update(id, student);
	}

	@GetMapping("third-party-api")
	public Objects callThirdPartyApi(){
		return studentService.callThirdPartyApi();

	}

}