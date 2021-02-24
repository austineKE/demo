package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Student_Repository extends JpaRepository<Student, String>{
    Optional<Student> findByUserName(String userName);
}
