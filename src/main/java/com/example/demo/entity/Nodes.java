package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.relational.core.mapping.Table;

@Entity
@Table(name="nodes")

public class Nodes {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int studentId;
    private String studentName;
    private String studentIntake;
    private String studentSection;
    
    
    

}
