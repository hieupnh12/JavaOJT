
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
        menu.addItem("Thoat");
        return menu;
    }
    
    public int getOption(Menu menu) {
        return menu.getChoiceFromMenu("HE THONG QUAN LI DAI HOC");
    }
    
    public Menu displayMenuStudent() {
        Menu menu = new Menu();
        menu.addItem("Them sinh vien");
        menu.addItem("Sua sinh vien");
        menu.addItem("Xoa sinh vien");
        menu.addItem("Quay lai");
        return menu;
    }
    
    public int getOptionStudent(Menu menu) {
        return menu.getChoiceFromMenu("QUAN LI SINH VIEN");
    }
    
    
}
