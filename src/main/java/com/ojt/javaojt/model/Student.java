
package com.ojt.javaojt.model;

import java.sql.Date;


public class Student {
    private int student_id;
    private String name;
    private Date date;
    private String email;

    public Student() {
    }

    public Student(String name, Date date, String email) {
        this.name = name;
        this.date = date;
        this.email = email;
    }

    public Student(int student_id, String name, Date date, String email) {
        this.student_id = student_id;
        this.name = name;
        this.date = date;
        this.email = email;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                 "|%-8s|%-25s|%-15s|%-25s|", this.student_id, this.name, this.date, this.email
        );   
    }
    
      
}
