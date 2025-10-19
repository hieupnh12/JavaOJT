package com.ojt.javaojt.view;

import com.ojt.javaojt.data.CourseDAO;
import com.ojt.javaojt.model.Course;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.validate_menu.Validation;
import java.util.ArrayList;

public class CourseView {
    private CourseDAO courseDAO;

    public CourseView(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public Menu displayMenuCourse() {
        Menu menu = new Menu();
        menu.addItem("Xem tat ca khoa hoc");
        menu.addItem("Them khoa hoc");
        menu.addItem("Sua khoa hoc");
        menu.addItem("Xoa khoa hoc");
        return menu;
    }

    public int getOptionCourse(Menu menu) {
        return menu.getChoiceFromMenu("QUAN LI KHOA HOC");
    }

    public Course inputCourse() {
        System.out.print("Nhap ten khoa hoc: ");
        String name = Validation.checkInputString();
        System.out.print("Nhap so tin chi (so nguyen duong): ");
        int credits = Validation.checkInputIntToArr();
        System.out.print("Nhap ID giang vien : ");
        String lect = Validation.checkInputString();
        Integer lecturerId = null;
        if (!lect.isEmpty()) {
            try {
                lecturerId = Integer.parseInt(lect);
            } catch (Exception e) {
                lecturerId = null;
            }
        }
        return new Course(name, credits, lecturerId);
    }

    public void displayCourses() {
        ArrayList<Course> list = courseDAO.getAllCourses();
        System.out.println("DANH SACH KHOA HOC");
        System.out.println(String.format("|%-6s|%-30s|%-8s|%-10s|", "ID", "Name", "Credits", "Lecturer"));
        if (list == null || list.isEmpty()) {
            System.out.println("  (No courses)");
            return;
        }
        for (Course c : list) {
            System.out.println(c.toString());
        }
    }
}