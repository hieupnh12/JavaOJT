
package com.ojt.javaojt.view;

import com.ojt.javaojt.data.StudentDAO;
import com.ojt.javaojt.model.Student;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.validate_menu.Validation;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;


public class StudentView {
    private StudentDAO studentDAO;

    public StudentView(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }
    
    public Menu displayMenuStudent() {
        Menu menu = new Menu();
        menu.addItem("Xem tat ca sinh vien");
        menu.addItem("Them sinh vien");
        menu.addItem("Sua sinh vien");
        menu.addItem("Xoa sinh vien");
        menu.addItem("Quan li file");
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
    
    public void displayStudent() throws SQLException {
        ArrayList<Student> arrayList = studentDAO.getAllStudents();
        System.out.println("DANH SACH SINH VIEN");
        System.out.println(String.format(
                 "|%-4s|%-25s|%-15s|%-25s|", "++ Id ++","++ Name ++","++ YOB ++","++ Email ++"));

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("" + arrayList.get(i).toString());
        }
    }
}
