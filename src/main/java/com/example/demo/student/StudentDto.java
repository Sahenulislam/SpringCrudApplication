package com.example.demo.student;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@Getter
@Setter
public class StudentDto {
    private Long id;
    private String name;
    private String intake;
    private String section;

    StudentDto(){

    }
    StudentDto(Student student){
        id=student.getId();
        name=student.getName();
        intake=student.getIntake();
        section=student.getSection();
    }
}
