package com.ojt.javaojt.data;

import com.ojt.javaojt.model.Course;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CourseDAO {

    public ArrayList<Course> getAllCourses() {
        try {
            ArrayList<Course> arrayList = new ArrayList<>();
            Connect connect = new Connect();
            ResultSet rs = connect.fetch("SELECT course_id, name, credits, lecturer_id FROM course");

            while (rs.next()) {
                int id = rs.getInt("course_id");
                String name = rs.getString("name");
                int credits = rs.getInt("credits");
                int lectId = rs.getInt("lecturer_id");
                Integer lecturerId = rs.wasNull() ? null : lectId;

                Course c = new Course(id, name, credits, lecturerId);
                arrayList.add(c);
            }
            connect.close();
            return arrayList;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    public boolean addCourse(Course c) {
        try {
            Connect connect = new Connect();
            String sql = "INSERT INTO course (name, credits, lecturer_id) VALUES ("
                    + "'" + c.getName().replace("'", "''") + "', "
                    + c.getCredits() + ", "
                    + (c.getLecturer_id() == null ? "NULL" : c.getLecturer_id())
                    + ")";
            // use Connect.query for insert/update/delete
            connect.query(sql);
            connect.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean updateCourse(Course c) {
        try {
            Connect connect = new Connect();
            String sql = "UPDATE course SET "
                    + "name = '" + c.getName().replace("'", "''") + "', "
                    + "credits = " + c.getCredits() + ", "
                    + "lecturer_id = " + (c.getLecturer_id() == null ? "NULL" : c.getLecturer_id())
                    + " WHERE course_id = " + c.getCourse_id();
            connect.query(sql);
            connect.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deleteCourse(int courseId) {
        try {
            Connect connect = new Connect();
            String sql = "DELETE FROM course WHERE course_id = " + courseId;
            connect.query(sql);
            connect.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // quick main for manual test
    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        ArrayList<Course> list = dao.getAllCourses();
        if (list != null) {
            for (Course c : list) {
                System.out.println(c);
            }
        }
    }
}