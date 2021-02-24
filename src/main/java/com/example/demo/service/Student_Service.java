package com.example.demo.service;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Student;
import com.example.demo.repository.Student_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Service
public class Student_Service{

    @Autowired
    private Student_Repository student_repository;

    public List<Student> getAllStudents() {
        return student_repository.findAll();
    }

    public Student getStudentById(String regNo) throws ResourceNotFoundException {
        Optional<Student> student=student_repository.findById(regNo);
        if (student.isPresent()){
            return student.get();
        }
        else {
            throw new ResourceNotFoundException("Not Found");
        }

    }

    public Student creteStudent(@RequestBody Student student){
        return student_repository.save(student);
    }

    public Student updateStudent(String regNo, Student studentDetails) throws ResourceNotFoundException {
        Student _student=student_repository.findById(regNo)
                .orElseThrow(() -> new ResourceNotFoundException("Not found" + regNo));

            _student.setRegNo(studentDetails.getRegNo());
            _student.setFirstName(studentDetails.getFirstName());
            _student.setSecondName(studentDetails.getSecondName());
            _student.setForm(studentDetails.getForm());
            return student_repository.save(_student);

    }

    public HttpStatus deleteStudent(String regNo) throws ResourceNotFoundException {
        Student _student=student_repository.findById(regNo)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found" + regNo));
        student_repository.delete(_student);
        return HttpStatus.OK;
    }

    public Student UserRegistration(String userName) throws ResourceNotFoundException{
        return student_repository.findByUserName(userName)
                .orElseThrow(() -> new ResourceNotFoundException("Check out your login credentials" ));
    }
}
