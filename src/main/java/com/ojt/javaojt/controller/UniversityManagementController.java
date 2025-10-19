
package com.ojt.javaojt.controller;

import com.ojt.javaojt.data.StudentDAO;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.StudentView;
import com.ojt.javaojt.view.UniversityManagementView;
import com.ojt.javaojt.controller.CourseController;
import java.sql.SQLException;


public class UniversityManagementController {
    private UniversityManagementView uniView;
    
    StudentDAO studentDAO = new StudentDAO();
    StudentView studentView = new StudentView(studentDAO);
    StudentController studentController = new StudentController(studentView);
    CourseController courseController = new CourseController();
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
                    System.out.println("Lecturer management not implemented yet.");
                    break;
                case 3:
                    courseController.start();
                    break;
                case 4:
                    System.out.println("Enrollment management not implemented yet.");
                    break;
                case 5:
                    System.out.println("Report generation not implemented yet.");
                    break;
                case 6: 
                    System.err.println("Exit Program!");
                    return;
                default:
                    System.err.println("Invalid option. Try again.");
            }
        }
    }
}
