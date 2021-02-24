package com.example.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    @Id
    private String regNo;
    private String firstName;
    private String secondName;
    private String form;
    private String userName;
    private String password;

//    public Student(String regNo, String firstName, String secondName, String form, String userName, String password) {
//        this.regNo = regNo;
//        this.firstName = firstName;
//        this.secondName = secondName;
//        this.form = form;
//        this.userName = userName;
//        this.password = password;
//    }


    public Student(Student student) {
        this.userName=student.getUserName();
        this.firstName=student.getFirstName();
        this.secondName=student.getSecondName();
        this.regNo=student.getRegNo();
        this.password=student.getPassword();
        this.form=student.getForm();

    }

    public String getRegNo() {
        return regNo;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getForm() {
        return form;
    }

    public String getPassword() {
        return password;
    }


    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
