
package com.ojt.testjdbc.connect;

import com.ojt.testjdbc.model.Lecture;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class ConnectV1<T> {
    private Connection connection;

    public ConnectV1() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=university_management;encrypt=true;trustServerCertificate=true;", "sa", "121121");
            System.out.println("Thanh cong!");
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Fail!");
        }
    }
    
    public int query(String sql, String... params) {
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }
    
    public ResultSet fetch(String sql, String... params) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i+1, params[i]);
        }
        
        return ps.executeQuery();
    }
    
    public void close() {
        try {
            if (!connection.isClosed() || connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {  
        
        insertLecturer(new Lecture("min", "liliana@gmail.com", "Van phong la"));
        
        for (Object object : listLecture()) {
            System.out.println(object);
        }
    }
    
    public static ArrayList listLecture() {
        ArrayList<Lecture> list = new ArrayList<>();
        try (Connect connect = new Connect()){
            ResultSet rs = connect.fetch("SELECT * FROM LECTURER");
            while (rs.next()) {                
                list.add(new Lecture(rs.getInt("lecturer_id"), rs.getString("name"), rs.getString("email"), rs.getString("department")));
            }
            return list;
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList();
        }
    } 
    
    public static void insertLecturer(Lecture lecture) {
        try (Connect connect = new Connect()){
            int check = connect.query("INSERT INTO LECTURER(name, email, department) VALUES(?, ?, ?)", lecture.getName(), lecture.getEmail(), lecture.getDepartment());
            if (check != -1) {
                System.out.println("ok" + check);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void saveFile(ArrayList<T> list, String fileName) {
        try (ObjectOutputStream obs = new ObjectOutputStream(new FileOutputStream(fileName))){
            obs.writeObject(list);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<T> loadAll(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (ArrayList<T>) ois.readObject();
        } catch (Exception e) {
            System.out.println(e);
            return new ArrayList<>();
        }
    }
}
