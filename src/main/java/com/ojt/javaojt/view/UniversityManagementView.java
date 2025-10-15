
package com.ojt.javaojt.view;

import com.ojt.javaojt.validate_menu.Menu;


public class UniversityManagementView {

    public UniversityManagementView() {
    }

    public Menu displayMainMenu() {
        Menu menu = new Menu();
        menu.addItem("Quan li thong tin sinh vien");
        menu.addItem("Quan li thong tin giang vien");
        menu.addItem("Quan li thong tin khoa hoc");
        menu.addItem("Dang ki mon hoc cho sinh vien");
        menu.addItem("Tao bao cao");
        return menu;
    }
    
    public int getOption(Menu menu) {
        return menu.getChoiceFromMenu("HE THONG QUAN LI DAI HOC");
    }
    
}
