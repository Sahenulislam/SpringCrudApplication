package com.example.demo.laptop;

import com.example.demo.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LaptopService {


    @Autowired
    LaptopRepository laptopRepository;


    public Laptop save(LaptopDto laptopDto){
        Laptop laptop=new Laptop(laptopDto);
        return laptopRepository.save(laptop);
    }
}
