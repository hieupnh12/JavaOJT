
package com.ojt.javaojt.controller;

import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.UniversityManagementView;


public class UniversityManagementController {
    private UniversityManagementView uniView;
    private StudentController studentController;
    public UniversityManagementController() {
    }

    public UniversityManagementController(UniversityManagementView uniView) {
        this.uniView = uniView;
    }
    
    public void start() {
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
                case 5: 
                    System.err.println("Exit Program!");
                    return;
                default:
                    throw new AssertionError();
            }
        }
    }
}
