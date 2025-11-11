
package com.ojt.testjdbc.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ConnectV2<T> {
    private Connection connection;

    public ConnectV2() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=university_management;encrypt=true;trustServerCertificate=true;", "sa", "121121");
            System.out.println("Success!");
        } catch (SQLException e) {
            System.out.println("Fail!");
            System.out.println(e);
        }
    }
    
    public int query(String sql, String... params) {
        try (PreparedStatement ps = connection.prepareStatement(sql);){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return -1;
        }
    }
    
    public ResultSet fetch(String sql, String... params) {
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            return ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    public static void main(String[] args) {
        ConnectV2 connectV2 = new ConnectV2();
    }
    
    public void saveFile(String fileName, ArrayList<T> list) {
        
    }
}
