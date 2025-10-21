
package com.ojt.javaojt.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Comparator;

public class Student implements Serializable, PrintFile, Comparable<Student>{
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
    
    @Override
    public String printFile() {
        return this.student_id + "," + this.name + "," + this.date + "," + this.email;   
    }

    public static Student fromFileString(String line) {
        String[] parts = line.split(",");
        try {
            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            Date yob = Date.valueOf(parts[2]);
            String email = parts[3];
            
            return new Student(id, name, yob, email);
        } catch (NumberFormatException e) {
            System.err.println(e);
            return null;
        }
    }

    @Override
    public int compareTo(Student o) {
        return this.date.compareTo(o.date);
    }

    public static Comparator<Student> comparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.name.compareTo(o2.name);
        }
    };
}
