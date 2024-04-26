package com.example.demo.entity;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name="student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int StudentId;
	@Column(name="student_name")
	private String StudentName;
	@Column(name="student_intake")
	private String StudentIntake;
	@Column(name="student_section")
	private String StudentSection;
	
	
	public Student() {	
	}
	
	
	public Student(int studentId, String studentName, String studentIntake, String studentSection) {
		super();
		StudentId = studentId;
		StudentName = studentName;
		StudentIntake = studentIntake;
		StudentSection = studentSection;
	}
	
	
	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", StudentIntake=" + StudentIntake
				+ ", StudentSection=" + StudentSection + "]";
	}
	
	
	public int getStudentId() {
		return StudentId;
	}
	
	
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	
	
	public String getStudentName() {
		return StudentName;
	}
	
	
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	
	
	public String getStudentIntake() {
		return StudentIntake;
	}
	
	
	public void setStudentIntake(String studentIntake) {
		StudentIntake = studentIntake;
	}
	
	
	public String getStudentSection() {
		return StudentSection;
	}
	
	
	public void setStudentSection(String studentSection) {
		StudentSection = studentSection;
	}
}
