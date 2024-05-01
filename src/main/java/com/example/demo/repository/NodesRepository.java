package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Nodes;

public interface NodesRepository extends JpaRepository<Nodes, Integer> {

}
