package com.example.demo.student;

import com.example.demo.laptop.Laptop;
import com.example.demo.laptop.LaptopDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

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

	@OneToMany(mappedBy="student", cascade = CascadeType.ALL)
	private List<Laptop> laptop;

	public Student() {

	}

	public Student(Long id, String name, String intake, String section) {
		this.id = id;
		this.name = name;
		this.intake = intake;
		this.section = section;
	}
}
