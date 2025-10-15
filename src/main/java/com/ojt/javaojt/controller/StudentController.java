
package com.ojt.javaojt.controller;

import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.StudentView;


public class StudentController {
    private StudentView studentView;

    public StudentController() {
    }

    public StudentController(StudentView studentView) {
        this.studentView = studentView;
    }
    
    public void start() {
        int choice;
        Menu menu = studentView.displayMenuStudent();
        
        while (true) {            
            choice = studentView.getOptionStudent(menu);
            
            switch (choice) {
                case 1 -> listAllStudent();
                case 2 -> addStudent();
                case 3 -> removeStudent(); 
                default -> throw new AssertionError();
            }
        }
    }
    
    // add student
    public void addStudent() {
        
    }
    
    // remove student
    public void removeStudent() {
        
    }
    
    // show all student
    public void listAllStudent() {
        
    }
} 
