package com.ojt.javaojt.controller;

import com.ojt.javaojt.data.CourseDAO;
import com.ojt.javaojt.model.Course;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.CourseView;
import java.sql.SQLException;
import com.ojt.javaojt.validate_menu.Validation;

public class CourseController {
    private CourseView courseView;
    private CourseDAO courseDAO;

    public CourseController() {
        this.courseDAO = new CourseDAO();
        this.courseView = new CourseView(courseDAO);
    }

    public CourseController(CourseView courseView) {
        this.courseView = courseView;
    }

    public void start() throws SQLException {
        int choice;
        Menu menu = courseView.displayMenuCourse();

        while (true) {
            choice = courseView.getOptionCourse(menu);

            switch (choice) {
                case 1 -> listAllCourse();
                case 2 -> addCourse();
                case 3 -> editCourse();
                case 4 -> removeCourse();
                case 5 -> { // Exit
                    return;
                }
                default -> throw new AssertionError();
            }
        }
    }

    public void addCourse() {
        Course c = courseView.inputCourse();
        boolean ok = courseDAO.addCourse(c);
        System.out.println(ok ? "them thanh cong." : "them that bai.");
    }

    public void editCourse() {
        try {
            courseView.displayCourses();
            System.out.print("Nhap ID khoa hoc de cap nhat: ");
            int id = Validation.checkInputInt();
            System.out.print("Nhap ten moi: ");
            String name = Validation.checkInputString();
            System.out.print("Nhap so tin chi moi: ");
            int credits = Validation.checkInputIntToArr();
            System.out.print("Nhap ID giang vien: ");
            String lect = Validation.checkInputString();
            Integer lecturerId = null;
            if (!lect.isEmpty()) {
                try {
                    lecturerId = Integer.parseInt(lect);
                } catch (Exception e) {
                    lecturerId = null;
                }
            }
            Course c = new Course(id, name, credits, lecturerId);
            boolean ok = courseDAO.updateCourse(c);
            System.out.println(ok ? "Cap nhat thanh cong." : "Cap nhat that bai.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void removeCourse() {
        courseView.displayCourses();
        System.out.print("Nhap ID khoa học de xoa: ");
        int id = Validation.checkInputInt();
        boolean ok = courseDAO.deleteCourse(id);
        System.out.println(ok ? "xoa thanh cong." : "xoa that bai.");
    }

    public void listAllCourse() throws SQLException {
        courseView.displayCourses();
    }
}