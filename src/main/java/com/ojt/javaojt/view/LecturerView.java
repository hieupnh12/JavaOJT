/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ojt.javaojt.view;

import com.ojt.javaojt.validate_menu.Menu;

/**
 *
 * @author Admin
 */
public class LecturerView {

    public LecturerView() {
    }
 
      public Menu displayMenuLecturer() {
        Menu menu = new Menu();
        menu.addItem("Them giang vien");
        menu.addItem("Sua giang vien");
        menu.addItem("Xoa giang vien");
        return menu;
    }
    
    public int getOptionLecturer(Menu menu) {
        return menu.getChoiceFromMenu("QUAN LI GIANG VIEN");
    }
    
}
