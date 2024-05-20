package com.example.demo.student;

import java.util.List;

//import com.example.demo.student.objects.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public StudentDto addStudent(@RequestBody StudentDto student) {
        return studentService.save(student);
    }


    @PostMapping("/save-all")
    public List<StudentDto> addStudents(@RequestBody List<StudentDto> student) {
        return studentService.saveAll(student);
    }

    @GetMapping("/find-all")
    public List<StudentDto> findAllStudent() {
        return studentService.findAll();
    }

    @GetMapping("/find/{id}")
    public StudentDto findStudentById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    /*@GetMapping("/find-all-student/{page}/{pageSize}")
    public Page<StudentDto> findAllStudent(@PathVariable int page, @PathVariable int pageSize) {
        return studentService.findAll(page, pageSize);
    }*/

   /* @GetMapping("/find-all-student-by-section/{Section}")
    public List<StudentDto> findAllStudentBySection(@PathVariable String Section) {
        return studentService.findAllBySection(Section);
    }*/

    @GetMapping("/find-all-student-by-section/{section}/{page}/{pageSize}")
    public Page<Student> findAllStudentBySection(@PathVariable String section, @PathVariable int page, @PathVariable int pageSize) {
        return studentService.findAllBySectionPaging(section, page, pageSize);

    }

    @GetMapping("find-all-laptop-by-user/{id}")
    public   List<StudentLaptopProjection> findAllLaptopByUser(@PathVariable Long id){
        return studentService.findAllLaptopByUser(id);
    }
    @GetMapping("find-all-laptop-by-all-user")
    public   List<StudentLaptopProjection> findAllLaptopByAllUser(){
        return studentService.findAllLaptopByAllUser();
    }

//    @GetMapping("find-all-laptop")
//    public List<Laptop> findAllLaptop(@PathVariable Long id){
//        return studentService.findAllLaptop(id);
//    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteById(id);
        return "product removed || " + id;
    }

    @PutMapping("/update-student/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.update(id, student);
    }


}