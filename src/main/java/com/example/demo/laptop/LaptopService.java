package com.example.demo.laptop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LaptopService {


    @Autowired
    LaptopRepository laptopRepository;


    public Laptop save(Laptop laptop){
        return laptopRepository.save(laptop);
    }
}
