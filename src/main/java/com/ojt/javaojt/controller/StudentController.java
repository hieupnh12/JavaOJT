
package com.ojt.javaojt.controller;

import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.FileView;
import com.ojt.javaojt.view.StudentView;
import java.sql.SQLException;
import java.text.ParseException;


public class StudentController {
    private StudentView studentView;
    
    public StudentController() {
    }

    public StudentController(StudentView studentView) {
        this.studentView = studentView;
    }
    
    public void start() throws SQLException, ParseException {
        int choice;
        Menu menu = studentView.displayMenuStudent();
        FileView fileView = new FileView();
        FileController fileController = new FileController(fileView);
        while (true) {            
            choice = studentView.getOptionStudent(menu);
            
            switch (choice) {
                case 1 -> studentView.displayStudent();
                case 2 -> this.studentView.addStudent();
                case 3 -> this.studentView.updateStudent();
                case 4 -> this.studentView.deleteStudent();
                case 5 -> fileController.start();
                case 6 -> {
                    return;
                }
                default -> throw new AssertionError();
            }
        }
    }
} 
