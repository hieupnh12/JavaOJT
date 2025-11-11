package com.ojt.testjdbc.connect;

import com.ojt.testjdbc.model.Lecture;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LectureDAO {

    public ArrayList<Lecture> allLecture() {
        ArrayList<Lecture> list = new ArrayList<>();
        try (Connect connect = new Connect(); ResultSet rs = connect.fetch("SELECT * FROM LECTURER")){           
            while (rs.next()) {                
                list.add(new Lecture(rs.getInt("lecturer_id"), rs.getString("name"), rs.getString("email"), rs.getString("department")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public void createAStudent(Lecture lecture) {
        try (Connect connect = new Connect()){
            int rows = connect.query("INSERT INTO LECTURER(name, email, department) VALUES (?, ?, ?)", lecture.getName(), lecture.getEmail(), lecture.getDepartment());
            if (rows>0) {
                System.out.println("ok");
            }
            connect.close();
        } catch (Exception e) {
            System.out.println("false " + e);
        }
    }
    
}
