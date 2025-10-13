
package com.ojt.javaojt.controller;

import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.UniversityManagementView;


public class UniversityManagementController {
    private UniversityManagementView uniView;

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
                    
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
