
package com.ojt.javaojt.controller;

import com.ojt.javaojt.data.StudentDAO;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.StudentView;
import com.ojt.javaojt.view.UniversityManagementView;
import java.sql.SQLException;


public class UniversityManagementController {
    private UniversityManagementView uniView;
    
    // Student
    StudentDAO studentDAO = new StudentDAO();
    StudentView studentView = new StudentView(studentDAO);
    StudentController studentController = new StudentController(studentView);
    public UniversityManagementController() {
    }

    public UniversityManagementController(UniversityManagementView uniView) {
        this.uniView = uniView;
    }
    
    public void start() throws SQLException {
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
                case 6: 
                    System.err.println("Exit Program!");
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
