package com.ojt.javaojt.controller;

import com.ojt.javaojt.validate_menu.Menu;
import com.ojt.javaojt.view.RepoView;

public class RepoController {
    private final RepoView repoView;

    public RepoController(RepoView repoView) {
        this.repoView = repoView;
    }

    public void start() {
        Menu menu = repoView.displayMenuRepo();
        while (true) {
            int choice = repoView.getOptionRepo(menu);
            switch (choice) {
                case 1 -> repoView.displayAllCourse();
                case 2 -> repoView.displayStudentsByCourse();
                case 3 -> repoView.displayAverageGradePerStudent();
                case 4 -> repoView.displayStudentCountPerCourse();
                case 5 -> {
                    System.out.println("Quay lai menu chinh...");
                    return;
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }
}
