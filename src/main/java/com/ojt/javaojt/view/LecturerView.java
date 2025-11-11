/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ojt.javaojt.view;

import com.ojt.javaojt.data.LectureDAO;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.validate_menu.Validation;

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
        menu.addItem("Cham diem");
        return menu;
    }
    
    public int getOptionLecturer(Menu menu) {
        return menu.getChoiceFromMenu("QUAN LI GIANG VIEN");
    }
    
    
    public void register() {
        System.out.print("Nhap Id: ");
        int idSv = Validation.checkInputInt();
        System.out.print("Nhap id course: ");
        int idCourse = Validation.checkInputInt();
        System.out.print("Nhap diem: ");
        double diem = Validation.checkInputDouble();
        
        String status;
        
        if (diem>=5) {
            status = "P";
        }else status = "N";
        LectureDAO lectureDAO = new LectureDAO();
        lectureDAO.dangKiDiem(diem, idSv, idCourse, status);
    }
}
