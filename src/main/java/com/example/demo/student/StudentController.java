package com.example.demo.student;

import java.util.List;
import java.util.Objects;

import com.example.demo.student.objects.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.demo.node.Nodes;

@RestController
@RequestMapping("student")
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
	public Student FindStudentById(@PathVariable Long id) {
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
	public String DeleteStudent(@PathVariable Long id) {
		studentService.deleteById(id);
		return "product removed || " + id;
	}

	@PutMapping("/UpdateStudent/{id}")
	public Student UpdateStudent(@PathVariable Long id, @RequestBody Student student) {
		return studentService.update(id, student);
	}

	@GetMapping("third-party-api")
	public Object callThirdPartyApi(){
		return studentService.callThirdPartyApi(2);

	}

}