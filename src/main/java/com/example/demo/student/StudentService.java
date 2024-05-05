package com.example.demo.student;

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


    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> saveAll(List<Student> student) {
        return studentRepository.saveAll(student);
    }


    public List<Student> findAll() {
        return studentRepository.findAll();
    }


    public Student findById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent())
            return student.get();

        return  null;
    }


    public List<Student> findAllBySection(String Section) {
        return studentRepository.findAllBySection(Section);
    }

    public Page<Student> findAllBySectionPaging(String section, int page, int pagesize) {
        return studentRepository.findAllBySection(section, PageRequest.of(page, pagesize));
    }

    public Page<Student> findAll(int page, int pagesize) {
        Pageable sortedByName = PageRequest.of(page, pagesize);
        return studentRepository.findAll(sortedByName);
    }

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
