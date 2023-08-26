package com.groovil.restapi.Student.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groovil.restapi.Student.students;
import com.groovil.restapi.Student.Services.studentService;

@RestController
@RequestMapping("/api/students")
public class StudentsController {
     @Autowired
    studentService studentservice;


    @PostMapping("/register")
    public students registerUser(@RequestBody Map<String, Object> userMap) {
        System.out.println("Hit");
        String name = (String) userMap.get("name");
        String rollNumber = (String) userMap.get("rollNumber");
        students student = studentservice.registerStudents(name, rollNumber);
        // return String.format("%d", student.getId());
        return student;
    }

    @GetMapping("/all")
    public List<Map<String, Object>> getAll() {
return studentservice.getAll();
    }

    @GetMapping("/{id}")
    public students getStudentByID(@PathVariable int id) {
        System.out.println("ID: " + id);
        return studentservice.FindByID(id);
    }
}
