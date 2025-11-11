
package com.ojt.testjdbc.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Connect implements AutoCloseable{
    private static Connection connection;
    
    public Connect() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=university_management;encrypt=true;trustServerCertificate=true",
                    "sa",
                    "121121"
            );
            System.out.println("Thanh cong");
        } catch (SQLException ex) {
            System.out.println("That bai" + ex);
        }
    }
    
    public int query(String sql, Object... params) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            return ps.executeUpdate();
        }  
    }
    
    public ResultSet fetch(String sql, Object... param) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        
        for (int i = 0; i < param.length; i++) {
            ps.setObject(i+1, param[i]);
        }
        return ps.executeQuery();
    }
    
    public void close() {
        try {
            if (connection!=null || !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
