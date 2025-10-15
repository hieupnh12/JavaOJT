package com.ojt.javaojt.data;

import com.ojt.javaojt.model.Student;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {
    
    public ArrayList<Student> getAllStudents() {
        try {
            ArrayList<Student> arrayList = new ArrayList<>();
            Connect connect = new Connect();
            ResultSet rs = connect.fetch("SELECT student_id, name, dob, email FROM STUDENT");
            
            while (rs.next()) {                
                int id = rs.getInt("student_id");
            String name = rs.getString("name");
            Date date = rs.getDate("dob");
            String email = rs.getString("email");

            Student st = new Student(id, name, date, email);
            arrayList.add(st);
            }
            connect.close();
            return arrayList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public static void main(String[] args) {
        StudentDAO st = new StudentDAO();
        try {
            ArrayList<Student> list = st.getAllStudents();
            for (Student student : list) {
                System.out.println("1" + student);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
