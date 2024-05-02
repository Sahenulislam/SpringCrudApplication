package com.example.demo.student;

import com.example.demo.student.objects.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {


   List<Student> findAllBySection(String section);

   Page<Student> findAllBySection(String section, Pageable pageable);
}

