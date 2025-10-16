
package com.ojt.javaojt.model;


public class Course {
    private int courseId;
    private String name;
    private int credits;
    private Lecturer lecturer;

    public Course() {
    }

    public Course(int courseId, String name, int credits, Lecturer lecturer) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.lecturer = lecturer;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", name=" + name + ", credits=" + credits + ", lecturer=" + lecturer + '}';
    }
    
    
}
