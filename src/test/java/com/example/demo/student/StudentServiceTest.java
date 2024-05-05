package com.example.demo.student;

import com.example.demo.student.Student;
import com.example.demo.student.StudentRepository;
import com.example.demo.student.StudentService;
import org.assertj.core.api.AbstractBigDecimalAssert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
//import com.example.demo.student.objects.Student;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentServiceTest {

    @Autowired
    StudentService studentService;


    @MockBean
    StudentRepository studentRepository;
/*
    @Test
    void save() {
    }

    @Test
    void saveAll() {
    }*/

    @Test
    void findAll() {
        long temp = 1;
        List<Student> expectedStudent = Arrays.asList(

                new Student(temp, "sahenul", "44", "2"),
                new Student(temp + 20, "rafi", "45", "2")
        );
        //System.out.println("ex stu: " + expectedStudent.size());


        when(studentRepository.findAll())
                .thenReturn(expectedStudent);

        //System.out.println(studentService.findAll().size());

        assertEquals(2, studentService.findAll().size());


    }

    @Test
    void findById() {

        Long temp = 1L;
//        List<Student> expectedStudent = Arrays.asList(
//
//                new Student(temp, "sahenul", "44", "2"),
//                new Student(temp + 20, "rafi", "45", "2")
//        );
        Student student =  new Student(temp, "sahenul", "44", "2");

        // Define behavior of mock
        when(studentRepository.findById(temp)).thenReturn(Optional.of(student));

        Student found = studentService.findById(temp);

        assertEquals(found.getId(), temp);
    }



/*
    @Test
    void findAllBySection() {
    }

    @Test
    void findAllBySectionPaging() {
    }

    @Test
    void testFindAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void update() {
    }*/
}
