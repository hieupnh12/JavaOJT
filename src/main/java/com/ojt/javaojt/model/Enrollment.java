package com.ojt.javaojt.model;

import java.sql.Date;

public class Enrollment {
    private int studentId;
    private int courseId;
    private Date enrollDate;
    private Double grade;
    
    public Enrollment() {}
    
    public Enrollment(int studentId, int courseId, Date enrollDate, Double grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollDate = enrollDate;
        this.grade = grade;
    }
    
    // Getters and Setters
    public int getStudentId() { 
        return studentId; 
    }
    
    public void setStudentId(int studentId) { 
        this.studentId = studentId; 
    }
    
    public int getCourseId() { 
        return courseId; 
    }
    
    public void setCourseId(int courseId) { 
        this.courseId = courseId; 
    }
    
    public Date getEnrollDate() { 
        return enrollDate; 
    }
    
    public void setEnrollDate(Date enrollDate) { 
        this.enrollDate = enrollDate; 
    }
    
    public Double getGrade() { 
        return grade; 
    }
    
    public void setGrade(Double grade) { 
        this.grade = grade; 
    }
    
    @Override
    public String toString() {
        return String.format("Enrollment{studentId=%d, courseId=%d, enrollDate=%s, grade=%s}", 
                studentId, courseId, enrollDate, grade);
    }
}
