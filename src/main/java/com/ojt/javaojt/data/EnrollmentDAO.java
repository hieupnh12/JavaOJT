package com.ojt.javaojt.data;

import com.ojt.javaojt.model.Enrollment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class EnrollmentDAO {
    private static final ReentrantLock lock = new ReentrantLock();
    
    // Kiem tra xem sinh vien da dang ky mon hoc chua
    public boolean isEnrolled(int studentId, int courseId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM enrollment WHERE student_id = ? AND course_id = ?";
        
        try (Connect connect = new Connect()) {
            ResultSet rs = connect.fetch(sql, studentId, courseId);
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
    
    // Dang ky mon hoc voi xu ly xung dot
    public boolean enrollStudent(int studentId, int courseId) throws SQLException {
        lock.lock();
        try {
            if (isEnrolled(studentId, courseId)) {
                System.out.println("Sinh vien da dang ky mon hoc nay roi!");
                return false;
            }

            if (!courseExists(courseId)) {
                System.out.println("Mon hoc khong ton tai!");
                return false;
            }
  
            if (!studentExists(studentId)) {
                System.out.println("Sinh vien khong ton tai!");
                return false;
            }
            
            // Thuc hien dang ky
            String sql = "INSERT INTO enrollment (student_id, course_id, enroll_date) VALUES (?, ?, GETDATE())";
            
            try (Connect connect = new Connect()) {
                connect.query(sql, studentId, courseId);
                System.out.println("Dang ky thanh cong!");
                return true;
            }
            
        } finally {
            lock.unlock();
        }
    }
    
    // Kiem tra mon hoc co ton tai khong
    private boolean courseExists(int courseId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM course WHERE course_id = ?";
        
        try (Connect connect = new Connect()) {
            ResultSet rs = connect.fetch(sql, courseId);
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
    
    // Kiem tra sinh vien co ton tai khong
    private boolean studentExists(int studentId) throws SQLException {
        String sql = "SELECT COUNT(*) FROM student WHERE student_id = ?";
        
        try (Connect connect = new Connect()) {
            ResultSet rs = connect.fetch(sql, studentId);
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
    
    // Lay danh sach dang ky cua sinh vien
    public List<Enrollment> getEnrollmentsByStudent(int studentId) throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM enrollment WHERE student_id = ?";
        
        try (Connect connect = new Connect()) {
            ResultSet rs = connect.fetch(sql, studentId);
            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                    rs.getInt("student_id"),
                    rs.getInt("course_id"),
                    rs.getDate("enroll_date"),
                    rs.getDouble("grade")
                );
                enrollments.add(enrollment);
            }
        }
        return enrollments;
    }
    
    // Lay danh sach sinh vien dang ky mon hoc
    public List<Enrollment> getEnrollmentsByCourse(int courseId) throws SQLException {
        List<Enrollment> enrollments = new ArrayList<>();
        String sql = "SELECT * FROM enrollment WHERE course_id = ?";
        
        try (Connect connect = new Connect()) {
            ResultSet rs = connect.fetch(sql, courseId);
            while (rs.next()) {
                Enrollment enrollment = new Enrollment(
                    rs.getInt("student_id"),
                    rs.getInt("course_id"),
                    rs.getDate("enroll_date"),
                    rs.getDouble("grade")
                );
                enrollments.add(enrollment);
            }
        }
        return enrollments;
    }
    
    // Huy dang ky mon hoc
    public boolean unenrollStudent(int studentId, int courseId) throws SQLException {
        lock.lock();
        try {
            String sql = "DELETE FROM enrollment WHERE student_id = ? AND course_id = ?";
            
            try (Connect connect = new Connect()) {
                connect.query(sql, studentId, courseId);
                System.out.println("Huy dang ky thanh cong!");
                return true;
            }
        } finally {
            lock.unlock();
        }
    }
}
