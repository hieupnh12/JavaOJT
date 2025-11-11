
package com.ojt.testjdbc.controller;

import com.ojt.testjdbc.model.Menu;
import com.ojt.testjdbc.view.LectureView;


public class LectureController {
    private LectureView lectureView;
    
    
    public void start() {
        int choice;
        Menu menu = lectureView.listMenu();
        while (true) { 
            choice = lectureView.displayMenu(menu);
            switch (1) {
                case 1:
                    
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
}
