package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.Student_Repository;
import com.example.demo.securitymodel.CustomStudentDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentDetailsService  implements UserDetailsService {

    @Autowired
    private Student_Repository student_repository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Optional<Student> student=student_repository.findByUserName(userName);
       student.orElseThrow(() -> new UsernameNotFoundException(userName + " Not found"));
       return student.map(CustomStudentDetails::new).get();
    }
}
