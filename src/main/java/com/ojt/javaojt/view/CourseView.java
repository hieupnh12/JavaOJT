
package com.ojt.javaojt.view;

import com.ojt.javaojt.data.StudentDAO;
import com.ojt.javaojt.model.Course;
import com.ojt.javaojt.model.CourseList;
import com.ojt.javaojt.model.Student;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.validate_menu.Validation;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;


public class CourseView {
    private CourseList courseList;

    public CourseView(CourseList courseList) {
        this.courseList = courseList;
    }
    public Menu displayMenuCouser() {
        Menu menu = new Menu();
        menu.addItem("Them khoa hoc tu file text");
        menu.addItem("Them khoa hoc thu cong khoa hoc");
        menu.addItem("Xem tat ca khoa hoc");
        menu.addItem("Xuat khoa hoc ra file excel");
        menu.addItem("Xoa khoa hoc");
        return menu;
    }
    
    public int getOptionCourse(Menu menu) {
        return menu.getChoiceFromMenu("QUAN LI KHOA HOC");
    }
    
    // input student
    public Student inputCourse() throws ParseException {
        System.out.print("Enter name: ");
        String name = Validation.checkInputString();
        System.out.print("Enter yob: ");
        Date date = Validation.checkInputDate();
        String email = Validation.checkInputString();
        
        return new Student(name, date, email);
    }
    
    public void displayCourse() throws SQLException {
        ArrayList<Course> arrayList = courseList.getAllCourse();
        System.out.println("DANH SACH KHOA HOC");
        System.out.println(String.format(
                 "|%-4s|%-30s|%-5s|%-5s|", "++ Id ++","++ Name ++","++ credits ++","++ lecturer_id ++"));

         for (Course c : arrayList) {
        System.out.printf("| %-5d | %-30s | %-8d | %-12d |%n",
                          c.getCourseId(),
                          c.getName(),
                          c.getCredits(),
                          c.getLecturer_id());
    }
    }
}
