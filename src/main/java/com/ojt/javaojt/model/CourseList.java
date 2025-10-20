package com.ojt.javaojt.model;

import com.ojt.javaojt.data.Connect;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CourseList {

    public void readCourseFile() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap duong dan toi file .txt (vd: D:/6ST-SEMESTER/assignment/javacore/course.txt): ");
        String filePath = scanner.nextLine().trim();

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println(" File không ton tai! Vui long kiem tra lai duong dan.");
            return;
        }

        Connect connect = new Connect();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            String sql = "INSERT INTO course (name, credits, lecturer_id) VALUES (?, ?, ?)";
            Connection conn = connect.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 3) {
                    System.out.println("️ Dong du lieu khong hop le: " + line);
                    continue;
                }

                stmt.setString(1, parts[0].trim());
                stmt.setInt(2, Integer.parseInt(parts[1].trim()));
                stmt.setInt(3, Integer.parseInt(parts[2].trim()));
                stmt.addBatch();
            }

            stmt.executeBatch();
            System.out.println("Import completed!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connect.close();
        }
    }

    public ArrayList<Course> getAllCourse() {
        try {
            ArrayList<Course> arrayList = new ArrayList<>();
            Connect connect = new Connect();
            ResultSet rs = connect.fetch("SELECT course_id, name, credits, lecturer_id FROM COURSE");

            while (rs.next()) {
                int id = rs.getInt("course_id");
                String name = rs.getString("name");
                int credits = rs.getInt("credits");
                int lecturer_id = rs.getInt("lecturer_id");

                Course st = new Course(id, name, credits, lecturer_id);
                arrayList.add(st);
            }
            connect.close();
            return arrayList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public void exportCourseTofile() throws SQLException {

        Connect connect = new Connect();

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap duong dan muon luu file (vd: D:/export/course.xlsx): ");
        String filePath = sc.nextLine();
        try {
            String sql = "SELECT course_id, name, credits, lecturer_id from course";
            Connection conn = connect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Courses");

            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("course id");
            header.createCell(1).setCellValue("course Name");
            header.createCell(2).setCellValue("course Credits");
            header.createCell(3).setCellValue("Lecture Id");

            int rowNum = 1;

            while (rs.next()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(rs.getInt("course_id"));
                row.createCell(1).setCellValue(rs.getString("name"));
                row.createCell(2).setCellValue(rs.getInt("credits"));
                row.createCell(3).setCellValue(rs.getInt("lecturer_id"));
            }

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);

            }

            workbook.close();
            System.out.println("Xuat file thanh cong tai: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertCourseManual() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connect connect = new Connect();
        Connection conn = connect.getConnection();

        String sql = "INSERT INTO course (name, credits, lecturer_id) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);

        System.out.println("=== Nhap thong tin khoa hoc thu cong ===");
        System.out.println("Nhan 'exit' de dung.");

        while (true) {
            System.out.print("Ten Khoa hoc: ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("So tin chi: ");
            int credits = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Ma giang vien: ");
            int lecturerId = Integer.parseInt(scanner.nextLine().trim());

            stmt.setString(1, name);
            stmt.setInt(2, credits);
            stmt.setInt(3, lecturerId);
            stmt.addBatch();

            System.out.println("Da them vao danh sach tam. (Nhap 'exit' de luu va thoat)");
        }

        int[] results = stmt.executeBatch();
        System.out.println(" Da luu " + results.length + " khoa hoc thanh cong!");

        connect.close();
    }

    public void deleteCourseById() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connect connect = new Connect();
        Connection conn = connect.getConnection();

        System.out.print("Nhap ID khoa hoc muon xoa: ");
        int id = Integer.parseInt(scanner.nextLine().trim());

        String sql = "DELETE FROM course WHERE course_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);

        int rows = stmt.executeUpdate();

        if (rows > 0) {
            System.out.println(" Da xoa khoa hoc co ID = " + id);
        } else {
            System.out.println(" Khong tim thay khoa học co ID = " + id);
        }

        connect.close();
    }

    public static void main(String[] args) {
        CourseList c = new CourseList();
        ArrayList<Course> cl = c.getAllCourse();

        for (Course course : cl) {
            System.out.println(" " + course.toString());
            System.out.println();
        }
    }

}
