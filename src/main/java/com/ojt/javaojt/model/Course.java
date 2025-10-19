package com.ojt.javaojt.model;

public class Course {
    private int course_id;
    private String name;
    private int credits;
    private Integer lecturer_id; // nullable

    public Course() {
    }

    public Course(String name, int credits, Integer lecturer_id) {
        this.name = name;
        this.credits = credits;
        this.lecturer_id = lecturer_id;
    }

    public Course(int course_id, String name, int credits, Integer lecturer_id) {
        this.course_id = course_id;
        this.name = name;
        this.credits = credits;
        this.lecturer_id = lecturer_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
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

    public Integer getLecturer_id() {
        return lecturer_id;
    }

    public void setLecturer_id(Integer lecturer_id) {
        this.lecturer_id = lecturer_id;
    }

    @Override
    public String toString() {
        return String.format("|%-6s|%-30s|%-8s|%-10s|",
                this.course_id, this.name, this.credits,
                (this.lecturer_id == null ? "NULL" : this.lecturer_id.toString()));
    }
}