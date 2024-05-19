package com.example.demo.laptop;


import com.example.demo.student.Student;
import jakarta.persistence.Access;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LaptopDto {
    private Long id;
    private String company;
    private Student student;
}
