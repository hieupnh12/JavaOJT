package com.ojt.javaojt.model;

import com.ojt.javaojt.data.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repo {

    // Danh sách sinh viên trong 1 khóa học cụ thể
    public List<String> getStudentsByCourse(String courseName) {
        List<String> result = new ArrayList<>();
        String sql = """
                SELECT s.name AS studentName, e.grade, e.enroll_date
                FROM enrollment e
                JOIN student s ON e.student_id = s.student_id
                JOIN course c ON e.course_id = c.course_id
                WHERE c.name = ?
                """;

        try (Connect conn = new Connect();
             ResultSet rs = conn.fetch(sql, courseName)) {
            while (rs.next()) {
                result.add(String.format("%-20s | Grade: %.2f | Enrolled: %s",
                        rs.getString("studentName"),
                        rs.getDouble("grade"),
                        rs.getDate("enroll_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Thống kê điểm trung bình theo sinh viên
    public List<String> getAverageGradePerStudent() {
        List<String> result = new ArrayList<>();
        String sql = """
                SELECT s.name AS studentName, AVG(e.grade) AS avgGrade
                FROM enrollment e
                JOIN student s ON e.student_id = s.student_id
                GROUP BY s.name
                ORDER BY avgGrade DESC
                """;

        try (Connect conn = new Connect();
             ResultSet rs = conn.fetch(sql)) {
            while (rs.next()) {
                result.add(String.format("%-20s | Avg Grade: %.2f",
                        rs.getString("studentName"),
                        rs.getDouble("avgGrade")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    // Thống kê số sinh viên mỗi khóa học
    public List<String> getStudentCountPerCourse() {
        List<String> result = new ArrayList<>();
        String sql = """
                SELECT c.name AS courseName, COUNT(e.student_id) AS studentCount
                FROM course c
                LEFT JOIN enrollment e ON c.course_id = e.course_id
                GROUP BY c.name
                ORDER BY studentCount DESC
                """;

        try (Connect conn = new Connect();
             ResultSet rs = conn.fetch(sql)) {
            while (rs.next()) {
                result.add(String.format("%-25s | Students: %d",
                        rs.getString("courseName"),
                        rs.getInt("studentCount")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
