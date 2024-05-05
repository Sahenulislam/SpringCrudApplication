package com.example.demo.student;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "intake")
	private String intake;
	@Column(name = "section")
	private String section;

	public Student() {
	}

	public Student(Long id, String name, String intake, String section) {
		this.id = id;
		this.name = name;
		this.intake = intake;
		this.section = section;
	}
}
