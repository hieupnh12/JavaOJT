/*
 */

package com.ojt.javaojt.data;

import java.sql.*;


public class Connect {
    private Connection connection;
    private String connecttionUrl = "jdbc:sqlserver://NHATSINH\\SINHNGUYEN:1433;"
            + "databaseName=university_management;"
            + "user=sa;"
            + "password=sa130220;"
            + "encrypt=true;trustServerCertificate=true;";
    
    public Connect() throws SQLException {
        
        try {
            connection = DriverManager.getConnection(connecttionUrl);
            System.out.println("Connect Server sucessfull.");
        } catch (SQLException e) {
            System.out.println("Connect Fail!");
            throw e;
        }
    }
    
    // Perform Insert Update Delete
    public void query(String sql, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql);
        
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i+1, params[i]);
        }
        
        statement.executeUpdate();
    }
    
    // Perform Select
    public ResultSet fetch(String sql, Object... params) throws SQLException{
        PreparedStatement statement = connection.prepareStatement(sql);
        
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i+1, params[i]);
        }
        return statement.executeQuery();
    }
    
    public void close() throws SQLException{
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    
}
