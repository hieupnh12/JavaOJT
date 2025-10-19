
package com.ojt.javaojt.model;


public class Course {
    private int courseId;
    private String name;
    private int credits;
    private int lecturer_id;

    public Course(int courseId, String name, int credits, int lecturer_id) {
        this.courseId = courseId;
        this.name = name;
        this.credits = credits;
        this.lecturer_id = lecturer_id;
    }
    
    

    public Course() {
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

    public int getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(int lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    @Override
    public String toString() {
        return "Course{" + "courseId=" + courseId + ", name=" + name + ", credits=" + credits + ", lecturer_id=" + lecturer_id + '}';
    }


    
    
}
