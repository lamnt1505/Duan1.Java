/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lamnt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class XJdbc {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl ="jdbc:sqlserver://localhost:1433;databaseName=QLTV_Project1";
    private static String username ="sa";
    private static String password ="123456";
    //
    static{
        try {            
            Class.forName(driver);
        } 
        catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    public static PreparedStatement getStmt(String sql, Object...args) throws SQLException{
       Connection conn = DriverManager.getConnection(dburl,username,password);
        PreparedStatement stmt = null;
        /*
          Nếu câu lệnh sql bắt đầu bằng "{" có nghĩa là lời gọi thủ tục
          Ngược lại là câu lênh sql
        */
        if(sql.trim().startsWith("{")){
            stmt = conn.prepareCall(sql); // thủ tục PROC
        }else{
            stmt = conn.prepareStatement(sql); // câu lệnh SQL
        }
        // Cho for duyệt, setObject có thể thay thế kiểu String, double, Boolean ,...
        for (int i = 0; i<args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }
                    
    public static void update(String sql, Object...args) {//insert, update, detele
        try {
            PreparedStatement stmt = XJdbc.getStmt(sql, args);
            try {
                stmt.executeUpdate();
            } 
            finally{
                stmt.getConnection().close();
            }
        } 
        catch (Exception e) {
            System.out.print(e.toString());
            throw new RuntimeException(e);
        }
    }
    public static ResultSet query(String sql, Object...args) {
        try {
            PreparedStatement stmt = XJdbc.getStmt(sql, args);
            return stmt.executeQuery();
        } 
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static Object value(String sql, Object...args) {
        try {
            ResultSet rs = XJdbc.query(sql, args);
            if(rs.next()){
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
