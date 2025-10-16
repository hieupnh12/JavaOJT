
package com.ojt.javaojt.model;


public class Lecturer {
    private int lecturerId;
    private String name;
    private String email;
    private String department;

    public Lecturer() {
    }

    public Lecturer(int lecturerId, String name, String email, String department) {
        this.lecturerId = lecturerId;
        this.name = name;
        this.email = email;
        this.department = department;
    }

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
        return "Lecturer{" + "lecturerId=" + lecturerId + ", name=" + name + ", email=" + email + ", department=" + department + '}';
    }
     
    
}
