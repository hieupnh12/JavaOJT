package com.ojt.javaojt.data;

import com.ojt.javaojt.model.Student;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

    public ArrayList<Student> getAllStudents() throws SQLException {
        ArrayList<Student> arrayList = new ArrayList<>();
        try (Connect connect = new Connect(); ResultSet rs = connect.fetch("SELECT student_id, name, dob, email FROM STUDENT")) {

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("name");
                Date date = rs.getDate("dob");
                String email = rs.getString("email");

                Student st = new Student(id, name, date, email);
                arrayList.add(st);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return arrayList;
    }

    public void addStudent(Student student) {
        try (Connect connect = new Connect();){
            connect.query("INSERT INTO STUDENT(name, dob, email) VALUES (?, ?, ?)", student.getName(), student.getDate(), student.getEmail());
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    
    public void deleteStudent(int id) {
        try (Connect connect = new Connect()){
            connect.query("DELETE FROM STUDENT WHERE student_id = ?", id);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    public void updateStudent(Student student) {
        try (Connect connect = new Connect()){
            connect.query("UPDATE STUDENT SET name = ?, dob = ?, email = ? WHERE id = ?",
                    student.getName(), student.getDate(), student.getEmail(), student.getStudent_id());
        } catch (Exception e) {
            System.err.println(e);
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
