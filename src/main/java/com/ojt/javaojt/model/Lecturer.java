package com.ojt.javaojt.model;

public class Lecturer {

    private int lecturerId;
    private String name;
    private String email;
    private String department;

    public Lecturer(int lecturerId, String name, String email, String department) {
        this.lecturerId = lecturerId;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public Lecturer(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }
    
    

    public Lecturer() {
    }

    
    
    
    // Getter và Setter
    public int getLecturerId() {
        return lecturerId;
    }
    
    public void setLecturerId(int lecturerId) {
        this.lecturerId = lecturerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format(
                "|%-8s|%-25s|%-25s|%-25s|", this.lecturerId, this.name, this.email , this.department
                );
    }
    
    
    
    
    
}

