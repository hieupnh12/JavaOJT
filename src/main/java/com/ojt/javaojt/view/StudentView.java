
package com.ojt.javaojt.view;

import com.ojt.javaojt.model.Student;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.validate_menu.Validation;
import java.sql.Date;
import java.text.ParseException;


public class StudentView {
    
    public Menu displayMenuStudent() {
        Menu menu = new Menu();
        menu.addItem("Xem tat ca sinh vien");
        menu.addItem("Them sinh vien");
        menu.addItem("Sua sinh vien");
        menu.addItem("Xoa sinh vien");
        menu.addItem("Quay lai");
        return menu;
    }
    
    public int getOptionStudent(Menu menu) {
        return menu.getChoiceFromMenu("QUAN LI SINH VIEN");
    }
    
    // input student
    public Student inputStudent() throws ParseException {
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        System.out.print("Enter yob: ");
        Date date = Validation.checkInputDate();
        String email = Validation.checkInputString();
        
        return new Student(name, date, email);
    }
    
    public void displayStudent() {
        
    }
}
