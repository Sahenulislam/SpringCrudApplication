package com.example.demo.student;

import java.util.List;

import com.example.demo.student.objects.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public Student addStudent(@RequestBody Student student) {
        return studentService.save(student);
    }


    @PostMapping("/add-all-student")
    public List<Student> addStudents(@RequestBody List<Student> student) {
        return studentService.saveAll(student);
    }

    @GetMapping("/find-all-student")
    public List<Student> findAllStudent() {
        return studentService.findAll();
    }

    @GetMapping("/find-student/{id}")
    public Student findStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping("/find-all-student/{page}/{pageSize}")
    public Page<Student> findAllStudent(@PathVariable int page, @PathVariable int pageSize) {
        return studentService.findAll(page, pageSize);
    }

    @GetMapping("/find-all-student-by-section/{Section}")
    public List<Student> findAllStudentBySection(@PathVariable String Section) {
        return studentService.findAllBySection(Section);
    }

    @GetMapping("/find-all-student-by-section/{section}/{page}/{pageSize}")
    public Page<Student> findAllStudentBySection(@PathVariable String section, @PathVariable int page, @PathVariable int pageSize) {
        return studentService.findAllBySectionPaging(section, page, pageSize);

    }

    @DeleteMapping("/delete-student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return "product removed || " + id;
    }

    @PutMapping("/update-student/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }


}