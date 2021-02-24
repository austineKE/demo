package com.example.demo.controller;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Student_Controller {

    @Autowired
    private Student_Service student_service;

    @GetMapping("/v1/students")
    public List<Student> getAllStudents() {
        return student_service.getAllStudents();
    }

    @GetMapping("/v1/student/{regNo}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "regNo") String regNo)
            throws ResourceNotFoundException {
                Student student=student_service.getStudentById(regNo);
        return ResponseEntity.ok().body(student);
    }

//    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secured/all")
    public String hello(){
        return "Hello world";
    }

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/v1/student")
    public Student createStudent(@RequestBody Student student){
        return student_service.creteStudent(student);

    }

    @PutMapping("/v1/student/{regNo}")
    @ResponseBody
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "regNo")
            String regNo, @RequestBody Student studentDetails)
            throws ResourceNotFoundException {
        Student updatedStudent=student_service.updateStudent(regNo, studentDetails);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/v/student/{regNo}")
    public HttpStatus deleteStudent(@PathVariable(value = "regNo") String regNo)
            throws ResourceNotFoundException{
        HttpStatus _student=student_service.deleteStudent(regNo);
        return _student;
    }


}
