package com.ojt.javaojt.controller;

import com.ojt.javaojt.service.ConcurrentEnrollmentService;
import com.ojt.javaojt.data.EnrollmentDAO;
import com.ojt.javaojt.validate_menu.Validation;
import java.sql.SQLException;
import java.util.Scanner;

public class EnrollmentController {
    private ConcurrentEnrollmentService enrollmentService;
    private EnrollmentDAO enrollmentDAO;
    private Scanner scanner;
    
    public EnrollmentController() {
        this.enrollmentService = new ConcurrentEnrollmentService();
        this.enrollmentDAO = new EnrollmentDAO();
        this.scanner = new Scanner(System.in);
    }
    
    public void start() throws SQLException {
        int choice;
        
        do {
            displayMenu();
            choice = getChoice();
            
            switch (choice) {
                case 1 -> simulateConcurrentEnrollment();
                case 2 -> simulateEnrollmentConflict();
                case 3 -> showEnrollmentResults();
                case 4 -> enrollSingleStudent();
                case 5 -> unenrollStudent();
                case 6 -> showStudentEnrollments();
                case 0 -> {
                    System.out.println("Thoat chuong trinh...");
                    enrollmentService.shutdown();
                    return;
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }
    
    private void displayMenu() {
        System.out.println("\n=== QUAN LY DANG KY MON HOC ===");
        System.out.println("1. Mo phong dang ky dong thoi");
        System.out.println("2. Mo phong xung dot dang ky");
        System.out.println("3. Xem ket qua dang ky mon hoc");
        System.out.println("4. Dang ky mon hoc cho sinh vien");
        System.out.println("5. Huy dang ky mon hoc");
        System.out.println("6. Xem mon hoc cua sinh vien");
        System.out.println("0. Thoat");
        System.out.println("================================");
        System.out.print("Chon: ");
    }
    
    private int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private void simulateConcurrentEnrollment() {
        System.out.print("Nhap ID mon hoc: ");
        int courseId = Validation.checkInputInt();
        
        System.out.print("Nhap so luong sinh vien: ");
        int numberOfStudents = Validation.checkInputInt();
        
        enrollmentService.simulateConcurrentEnrollment(courseId, numberOfStudents);
        
        // Doi mot chut de cac thread hoan thanh
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void simulateEnrollmentConflict() {
        System.out.print("Nhap ID mon hoc: ");
        int courseId = Validation.checkInputInt();
        
        System.out.print("Nhap danh sach ID sinh vien (cach nhau boi dau phay): ");
        String input = Validation.checkInputString();
        String[] parts = input.split(",");
        int[] studentIds = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            studentIds[i] = Integer.parseInt(parts[i].trim());
        }
        
        enrollmentService.simulateEnrollmentConflict(courseId, studentIds);
        
        // Doi mot chut de cac thread hoan thanh
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void showEnrollmentResults() throws SQLException {
        System.out.print("Nhap ID mon hoc: ");
        int courseId = Validation.checkInputInt();
        
        enrollmentService.showEnrollmentResults(courseId);
    }
    
    private void enrollSingleStudent() {
        System.out.print("Nhap ID sinh vien: ");
        int studentId = Validation.checkInputInt();
        
        System.out.print("Nhap ID mon hoc: ");
        int courseId = Validation.checkInputInt();
        
        try {
            boolean success = enrollmentDAO.enrollStudent(studentId, courseId);
            if (success) {
                System.out.println("Dang ky thanh cong!");
            } else {
                System.out.println("Dang ky that bai!");
            }
        } catch (SQLException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }
    
    private void unenrollStudent() {
        System.out.print("Nhap ID sinh vien: ");
        int studentId = Validation.checkInputInt();
        
        System.out.print("Nhap ID mon hoc: ");
        int courseId = Validation.checkInputInt();
        
        try {
            boolean success = enrollmentDAO.unenrollStudent(studentId, courseId);
            if (success) {
                System.out.println("Huy dang ky thanh cong!");
            } else {
                System.out.println("Huy dang ky that bai!");
            }
        } catch (SQLException e) {
            System.err.println("Loi: " + e.getMessage());
        }
    }
    
    private void showStudentEnrollments() throws SQLException {
        System.out.print("Nhap ID sinh vien: ");
        int studentId = Validation.checkInputInt();
        
        var enrollments = enrollmentDAO.getEnrollmentsByStudent(studentId);
        
        System.out.println("\n=== MON HOC CUA SINH VIEN " + studentId + " ===");
        if (enrollments.isEmpty()) {
            System.out.println("Sinh vien chua dang ky mon hoc nao.");
        } else {
            System.out.println("So luong mon hoc: " + enrollments.size());
            for (var enrollment : enrollments) {
                System.out.println("- Mon hoc ID: " + enrollment.getCourseId() + 
                                 ", Ngay dang ky: " + enrollment.getEnrollDate());
            }
        }
        System.out.println("=====================================\n");
    }
}
