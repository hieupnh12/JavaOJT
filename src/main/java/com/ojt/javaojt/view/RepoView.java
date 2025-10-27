package com.ojt.javaojt.view;

import com.ojt.javaojt.model.Repo;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.validate_menu.Validation;
import com.ojt.javaojt.model.CourseList;
import java.util.List;

public class RepoView {

    private final Repo repo;
    private final CourseList courseList;

    public RepoView(Repo repo, CourseList courseList) {
        this.repo = repo;
        this.courseList = courseList;
    }

    public Menu displayMenuRepo() {
        Menu menu = new Menu();
        menu.addItem("Danh sach khoa hoc");
        menu.addItem("Danh sach sinh vien trong mot khoa hoc");
        menu.addItem("Diem trung binh cua tung sinh vien");
        menu.addItem("So luong sinh vien moi khoa hoc");
        return menu;
    }

    public int getOptionRepo(Menu menu) {
        return menu.getChoiceFromMenu("BAO CAO THONG KE");
    }

// danh sach khoa hoc 
    public void displayAllCourse() {
        CourseView courseView = new CourseView(courseList);
        try {
            courseView.displayCourse();
        } catch (Exception e) {
            System.out.println("Loi hien thi danh sach khoa hoc" + e.getMessage());
        }
    }

//danh sach sinh vien theo khoa hoc
    public void displayStudentsByCourse() {
        System.out.print("Nhap id khoa hoc: ");
        String course_id = Validation.checkInputString();

        List<String> list = repo.getStudentsByCourse(course_id);
        if (list.isEmpty()) {
            System.out.println("Khong co sinh vien nao trong khoa hoc nay!");
            return;
        }

        System.out.println("\nDANH SACH SINH VIEN TRONG KHOA HOC: " + course_id);
        list.forEach(System.out::println);
    }

//diem trung binh moi sinh vien
    public void displayAverageGradePerStudent() {
        System.out.println("\nDIEM TRUNG BINH THEO SINH VIEN");
        List<String> list = repo.getAverageGradePerStudent();
        list.forEach(System.out::println);
    }

//so luong sinh vien moi khoa hoc
    public void displayStudentCountPerCourse() {
        System.out.println("\nSO LUONG SINH VIEN MOI KHOA HOC");
        List<String> list = repo.getStudentCountPerCourse();
        list.forEach(System.out::println);
    }
}
