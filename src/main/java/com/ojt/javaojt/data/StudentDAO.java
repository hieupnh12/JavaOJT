package com.ojt.javaojt.data;

import com.ojt.javaojt.model.Student;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

    public ArrayList<Student> getAllStudent() throws SQLException {
        ArrayList<Student> arrStudents = new ArrayList<>();
        Connect connect = new Connect();
        ResultSet rs = connect.fetch("SELECT student_id, name, yob, email FROM STUDENT");

        while (rs.next()) {
            int id = rs.getInt("student_id");
            String name = rs.getString("name");
            Date date = rs.getDate("yob");
            String email = rs.getString("email");

            Student st = new Student(id, name, date, email);
            arrStudents.add(st);
        }
        connect.close();
        System.err.println("Load Succesfull!");
        return arrStudents;
    }

    public static void main(String[] args) {
        StudentDAO st = new StudentDAO();
        try {
            ArrayList<Student> list = st.getAllStudent();
            for (Student student : list) {
                System.out.println("1" + student);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
