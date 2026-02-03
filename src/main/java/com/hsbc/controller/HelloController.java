package com.hsbc.controller;

import com.hsbc.entity.Student;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @GetMapping("/")
    public String sayHelloGet(){
        return "hello-GET";
    }

    @PostMapping
    public String sayHelloPost(){
        return "hello- POST";
    }

    //http://localhost:8080/Vidya/java
    @GetMapping("/{x}/{y}")
    public String sayHelloName(@PathVariable("x") String name,@PathVariable("y") String tech){
        return "Hello "+name+", working in "+tech;
    }


    /*
    post
    http://localhost:8080/Student
    Body: raw: tet format json
    {
    "id":"14",
    "email":"v@gmail.com",
    "name":"vidya"
     }
     */

    @PostMapping("/student")
    public String saveStudent(@RequestBody Student student){
        System.out.println(student);
        return "Saved successfully";
    }

    @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(101,"vidya","b@gmail.com");
        return student;
    }



}
