
package com.ojt.javaojt.controller;

import com.ojt.javaojt.data.StudentDAO;
import com.ojt.javaojt.model.CourseList;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.CourseView;
import com.ojt.javaojt.view.StudentView;
import com.ojt.javaojt.view.UniversityManagementView;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;


public class UniversityManagementController {
    private UniversityManagementView uniView;
    
    // Student
    StudentDAO studentDAO = new StudentDAO();
    CourseList courseList = new CourseList();
    StudentView studentView = new StudentView(studentDAO);
    StudentController studentController = new StudentController(studentView);
    CourseView couserView = new CourseView(courseList);
    CourseController courseController = new CourseController(couserView);
    public UniversityManagementController() {
    }

    public UniversityManagementController(UniversityManagementView uniView) {
        this.uniView = uniView;
    }
    
    public void start() throws SQLException, IOException, ParseException {
        int choice;
        Menu menu = this.uniView.displayMainMenu();
        
        while (true) {            
            choice = this.uniView.getOption(menu);
            
            switch (choice) {
                case 1:
                    studentController.start();
                    break;
                case 2:
                    break;
                case 3:
                    courseController.start();
                    break;
                case 6: 
                    System.err.println("Exit Program!");
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
