package com.example.demo.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


//import com.example.demo.student.objects.Student;
import org.springframework.data.domain.Page;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;


    // Save single object;
    public StudentDto save(StudentDto studentDto) {
        Student student=new Student(studentDto);
        studentRepository.save(student);
        studentDto.setId(student.getId());
        return studentDto;
    }

    // Save multiple object;
    public List<StudentDto> saveAll(List<StudentDto> pStudentDto) {
        List<Student>student=new ArrayList<Student>();
        for(StudentDto studentDto:pStudentDto){
            Student _student= new Student(studentDto);
            student.add(_student);
        }
        studentRepository.saveAll(student);
        return pStudentDto;
    }

    // Find multiple object;
    public List<StudentDto> findAll() {
        List<Student>student=studentRepository.findAll();
        List<StudentDto>studentDto=new ArrayList<StudentDto>();
        for(Student _student:student){
            StudentDto _studentdto= new StudentDto(_student);
            studentDto.add(_studentdto);
        }
        return studentDto;
    }

    //Find single object;
    public StudentDto findById(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student==null)
            return null;
        StudentDto studentDto=new StudentDto(student);
        return studentDto;
    }

    public  List<StudentLaptopProjection> findAllLaptopByUser(Long id){
        List<StudentLaptopProjection> student = studentRepository.findAllLaptopByUser(id);
       return student;
    }

    public  List<StudentLaptopProjection> findAllLaptopByAllUser(){
        List<StudentLaptopProjection> student = studentRepository.findAllLaptopByAllUser();
        return student;
    }


    public List<Student> findAllBySection(String Section) {
        return studentRepository.findAllBySection(Section);
    }

    public Page<Student> findAllBySectionPaging(String section, int page, int pagesize) {
        return studentRepository.findAllBySection(section, PageRequest.of(page, pagesize));
    }

    public Page<Student> findAll(int page, int pageSize) {
        Pageable sortedByName = PageRequest.of(page, pageSize);
        return studentRepository.findAll(sortedByName);
    }

    /*public List<Laptop> findAllLaptop(Long id){
        return studentRepository.findById(id);
    }*/

    public String deleteById(Long id) {
        studentRepository.deleteById(id);
        return "product removed || " + id;
    }

    // not needed
    public Student update(Long id, Student pStudent) {
        // Find the existing student by ID
        Optional<Student> optionalExistingStudent = studentRepository.findById(id);


        // Check if the student exists in the database
        if (optionalExistingStudent.isPresent()) {
            Student existingStudent = optionalExistingStudent.get();

            // Update the existing student's data with the new data
            existingStudent.setName(pStudent.getName());
            existingStudent.setIntake(pStudent.getIntake());
            existingStudent.setSection(pStudent.getSection());

            // Save the updated student record in the database
            return studentRepository.save(existingStudent); ////////////save alada
        } else {
            // Handle the case where the student with the given ID does not exist
            // You might throw an exception, return null, or handle it in some other way
            return null;
        }
    }


}
