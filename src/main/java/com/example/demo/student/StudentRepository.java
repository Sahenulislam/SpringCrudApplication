package com.example.demo.student;

//import com.example.demo.student.objects.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

   @Query(value = "SELECT s.id as studentId, s.name as studentName, s.intake, s.section, l.id as laptopId, l.company as laptopCompany " +
           "FROM student s " +
           "INNER JOIN laptop l ON s.id = l.student_id " +
           "WHERE s.id = :id", nativeQuery = true)
   List<StudentLaptopProjection> findAllLaptopByStudentId(@Param("id") Long id);
   List<Student> findAllBySection(String section);

   Page<Student> findAllBySection(String section, Pageable pageable);
}

