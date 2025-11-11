
package com.ojt.testjdbc.view;

import com.ojt.testjdbc.model.Menu;


public class LectureView {
    
    public Menu listMenu() {
        Menu menu = new Menu();
        menu.addMenu("");
        
        return menu;
    }
    
    public int displayMenu(Menu menu) {
        return menu.printMenu("d");
    }
}
