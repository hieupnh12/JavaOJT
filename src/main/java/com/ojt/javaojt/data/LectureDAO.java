
package com.ojt.javaojt.data;

import com.ojt.javaojt.model.Lecturer;
import com.ojt.javaojt.validate_menu.Validation;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class LectureDAO {
        public ArrayList<Lecturer> liLecturer ;

    public LectureDAO() {
        this.liLecturer =  new ArrayList<>();
    }
     
    
    
    public void ListAllLecturer() throws SQLException{
        Connect connect = new Connect() ;
        try(ResultSet rst = connect.fetch("SELECT * FROM Lecturer")){
            while(rst.next()){
               int id = rst.getInt("lecturer_id");
               String name = rst.getString("name");
               String email = rst.getString("email");
               String department = rst.getString("department");
               
               Lecturer lecturer = new Lecturer(id, name, email, department);
               liLecturer.add(lecturer);
            }    
        }   
    }
    
    
    
    public ArrayList<Lecturer> getLecturers() {
        return liLecturer;
    }
           
    
    
    
    
    
    public void AddLecturer( Lecturer lecture) {        
        try(Connect connect = new Connect();){             
              connect.query("INSERT INTO lecturer (name, email, department) values (?,?,?)", lecture.getName(),lecture.getEmail(),lecture.getDepartment());
        }catch(SQLException e){
            System.out.println(e);
        }
       
    }
    
    
    
    
    
    
//    public void UpdateLecturer(Connection cn, Lecturer lecture) throws SQLException {
//        String sql = "{CALL udpate_Lecture(?,?,?,?)}";
//        try (CallableStatement cst = cn.prepareCall(sql)) {
//            
//            cst.setInt(1, lecture.getLecturerId());
//            cst.setString(2, lecture.getName());
//            cst.setString(3, lecture.getEmail());
//            cst.setString(4, lecture.getDepartment());
//
//            int rows = cst.executeUpdate();
//            if (rows > 0) {
//                System.out.println("Lecturer updated successfully via procedure.");
//            } else {
//                System.out.println("No lecturer found with that ID.");
//            }
//            cn.close();
//        }
//    }

    public void UpdateLecturer(Lecturer lecture,int id) throws SQLException {
        try (Connect connect = new Connect();) {            
            connect.query("Update Lecturer SET name =? , email=? , department=? WHere lecturer_id=?", lecture.getName(),lecture.getEmail(),id);
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    
    
    
    
    
    
    public void RemoveLecturer(int id)throws SQLException{
        try(Connect connect = new Connect();){
          connect.query("Delete FROM lecturer Where lecturer_id= ?", id);
        }catch(SQLException e){
            System.out.println(e);
        }       
    }
    
    public void dangKiDiem(double grade, int id, int course, String status) {
        try (Connect connect = new Connect()){
            connect.query("UPDATE ENROLLMENT SET Grade = ?, STATUS = ? WHERE STUDENT_ID = ? AND COURSE_ID = ?", grade, status, id, course);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    public static void main(String[] args) {
        // Khởi tạo kết nối
        try {
            Connect connect = new Connect();
            Connection cn = connect.getConnection();

            if (cn == null) {
                System.out.println("Connection failed!");
            } else {
                System.out.println("Connected successfully!");
            }
//            //tao doi tuong danh sach 
            LectureDAO lectureList = new LectureDAO();
            lectureList.ListAllLecturer();

            for (Lecturer lec : lectureList.getLecturers()) {
                System.out.println(""+lec.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
