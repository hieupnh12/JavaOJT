package com.ojt.javaojt.service;

import com.ojt.javaojt.data.EnrollmentDAO;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class ConcurrentEnrollmentService {
    private EnrollmentDAO enrollmentDAO;
    private ExecutorService executorService;
    
    public ConcurrentEnrollmentService() {
        this.enrollmentDAO = new EnrollmentDAO();
        this.executorService = Executors.newFixedThreadPool(10);
    }
    
    // Mo phong nhieu sinh vien cung dang ky mon hoc
    public void simulateConcurrentEnrollment(int courseId, int numberOfStudents) {
        System.out.println("=== BAT DAU MO PHONG DANG KY DONG THOI ===");
        System.out.println("Mon hoc ID: " + courseId);
        System.out.println("So luong sinh vien: " + numberOfStudents);
        System.out.println("==========================================");
        
        Random random = new Random();
        
        for (int i = 1; i <= numberOfStudents; i++) {
            final int studentId = i;
            executorService.submit(() -> {
                try {
                    // Them do tre ngau nhien de mo phong thuc te
                    Thread.sleep(random.nextInt(1000) + 500);
                    
                    System.out.println("Sinh vien " + studentId + " dang co gang dang ky mon hoc " + courseId);
                    
                    boolean success = enrollmentDAO.enrollStudent(studentId, courseId);
                    
                    if (success) {
                        System.out.println(" Sinh vien " + studentId + " dang ky THANH CONG mon hoc " + courseId);
                    } else {
                        System.out.println("Sinh vien " + studentId + " dang ky THAT BAI mon hoc " + courseId);
                    }
                    
                } catch (SQLException | InterruptedException e) {
                    System.err.println("Loi khi sinh vien " + studentId + " dang ky: " + e.getMessage());
                }
            });
        }
    }
    
    // Mo phong xung dot khi nhieu sinh vien dang ky cung luc
    public void simulateEnrollmentConflict(int courseId, int[] studentIds) {
        System.out.println("=== MO PHONG XUNG DOT DANG KY ===");
        System.out.println("Mon hoc ID: " + courseId);
        System.out.println("Danh sach sinh vien: " + java.util.Arrays.toString(studentIds));
        System.out.println("=================================");
        
        for (int studentId : studentIds) {
            executorService.submit(() -> {
                try {
                    System.out.println("Sinh vien " + studentId + " dang dang ky mon hoc " + courseId + " tai thoi diem: " + 
                                     java.time.LocalDateTime.now());
                    
                    boolean success = enrollmentDAO.enrollStudent(studentId, courseId);
                    
                    if (success) {
                        System.out.println(" Sinh vien " + studentId + " dang ky THANH CONG");
                    } else {
                        System.out.println(" Sinh vien " + studentId + " dang ky THAT BAI (co the da dang ky truoc do)");
                    }
                    
                } catch (SQLException e) {
                    System.err.println("Loi khi sinh vien " + studentId + " dang ky: " + e.getMessage());
                }
            });
        }
    }
    
    // Hien thi ket qua dang ky
    public void showEnrollmentResults(int courseId) throws SQLException {
        System.out.println("\n=== KET QUA DANG KY MON HOC " + courseId + " ===");
        var enrollments = enrollmentDAO.getEnrollmentsByCourse(courseId);
        
        if (enrollments.isEmpty()) {
            System.out.println("Chua co sinh vien nao dang ky mon hoc nay.");
        } else {
            System.out.println("So luong sinh vien da dang ky: " + enrollments.size());
            System.out.println("Danh sach sinh vien:");
            for (var enrollment : enrollments) {
                System.out.println("- Sinh vien ID: " + enrollment.getStudentId() + 
                                 ", Ngay dang ky: " + enrollment.getEnrollDate());
            }
        }
        System.out.println("=====================================\n");
    }
    
    // Don dep va dong service
    public void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();  
        }
    }
}
