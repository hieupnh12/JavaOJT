
package com.ojt.javaojt.model;

import java.time.LocalDate;


public class Student {
      private int studentId;
      private String name;
      private LocalDate dob;
      private String mail;

    public Student(int studentId, String name, LocalDate dob, String mail) {
        this.studentId = studentId;
        this.name = name;
        this.dob = dob;
        this.mail = mail;
    }

    public Student() {
    }

      
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Student{" + "studentId=" + studentId + ", name=" + name + ", dob=" + dob + ", mail=" + mail + '}';
    }
      
      
}
