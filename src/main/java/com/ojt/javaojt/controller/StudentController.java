
package com.ojt.javaojt.controller;

import com.ojt.javaojt.data.StudentDAO;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.StudentView;
import java.sql.SQLException;


public class StudentController {
    private StudentView studentView;
    
    public StudentController() {
    }

    public StudentController(StudentView studentView) {
        this.studentView = studentView;
    }
    
    public void start() throws SQLException {
        int choice;
        Menu menu = studentView.displayMenuStudent();
        
        while (true) {            
            choice = studentView.getOptionStudent(menu);
            
            switch (choice) {
                case 1 -> listAllStudent();
                case 2 -> addStudent();
                case 3 -> removeStudent(); 
                case 5 -> {
                    return;
                }
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
    public void listAllStudent() throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        StudentView stView = new StudentView(studentDAO);
        stView.displayStudent();
    }
} 
