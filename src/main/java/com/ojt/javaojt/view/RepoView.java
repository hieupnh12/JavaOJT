package com.ojt.javaojt.view;

import com.ojt.javaojt.model.Repo;
import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.validate_menu.Validation;
import java.util.List;

public class RepoView {
    private final Repo repo;

    public RepoView(Repo repo) {
        this.repo = repo;
    }

    public Menu displayMenuRepo() {
        Menu menu = new Menu();
        menu.addItem("Danh sach sinh vien trong mot khoa hoc");
        menu.addItem("Diem trung binh cua tung sinh vien");
        menu.addItem("So luong sinh vien moi khoa hoc");
        return menu;
    }

    public int getOptionRepo(Menu menu) {
        return menu.getChoiceFromMenu("BAO CAO THONG KE");
    }

//danh sach sinh vien theo khoa hoc
    public void displayStudentsByCourse() {
        System.out.print("Nhap ten khoa hoc: ");
        String courseName = Validation.checkInputString();

        List<String> list = repo.getStudentsByCourse(courseName);
        if (list.isEmpty()) {
            System.out.println("Khong co sinh vien nao trong khoa hoc nay!");
            return;
        }

        System.out.println("\nDANH SACH SINH VIEN TRONG KHOA HOC: " + courseName);
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
