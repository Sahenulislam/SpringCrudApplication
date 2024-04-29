package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
    
    @Autowired
    StudentService servi;
    
    @PostMapping("/AddStudent")
    public Student addStudent(@RequestBody Student student) {
        return servi.save(student);
    }
    
    
    @PostMapping("/AddStudents")
    public List<Student> addStudents(@RequestBody List<Student>student) {
        return servi.saveAll(student);
    }
    
    
    @GetMapping("/FindStudents")
    public List<Student>FindAllStudents(){
        return servi.findAll();
    }
    
    
    @GetMapping("/FindStudent/{id}")
    public Student FindStudentById(@PathVariable  int id) {
        return servi.findById(id);
    }
    
//    
//    @GetMapping("/FindStudentsPagination/{page}/{pagesize}")
//    public Page<Student> FindStudentPagination(@PathVariable int page,@PathVariable int pagesize)
//    {
//        return servi.getStudentPagination(page,pagesize);
//    
//    }
//    
//    
    @DeleteMapping("/DeleteStudent/{id}")
    public String DeleteStudent(@PathVariable int id) {
        servi.deleteById(id);
        return "product removed || "+id; 
    }
    
    
    @PutMapping("/UpdateStudent/{id}")
    public Student UpdateStudent(@PathVariable int id, @RequestBody Student student)
    {
        return servi.update(id,student);
    }
    
}
