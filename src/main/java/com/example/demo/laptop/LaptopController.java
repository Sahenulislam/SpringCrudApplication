package com.example.demo.laptop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import  com.example.demo.laptop.LaptopService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/laptop")
public class LaptopController {


    @Autowired
    LaptopService laptopService;

    @PostMapping("/save")
    public Laptop save(@RequestBody Laptop laptop){
        return laptopService.save(laptop);
    }



}
