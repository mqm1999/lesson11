/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package lesson11.Helper;
//
//
//import java.sql.*; //import tat ca trong thu vien
//
///**
// *
// * @author HP Pavilion
// */
//public class Connector {
//
//    private static Connector INSTANCE = null; 
//    private static Connection connection = null;
//
//    private Connector() {
//
//    }
//
//    public static Connector getInstance() {
//        if (INSTANCE == null) {
//            try {
//                Class.forName("com.mysql.jdbc.Driver");
//            } catch (ClassNotFoundException e) {
//                System.out.println(e);
//                return null;
//            } //khai bao driver JDBC
//
//            try {
//                INSTANCE = Connector.getInstance();
//                connection = DriverManager.getConnection("jdbc:mysql://codedidungso.me/MaiQuangMinh", "root", "100000");
//                return INSTANCE;
//            } catch (SQLException e) {
//                System.out.println(e);
//                return null;
//            }
//        } else {
//            return INSTANCE;
//        }
//    }
//    
//    public ResultSet executeQuery(String sql){ // ResultSet la tap. hop. cac' ban? ghi
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            return rs;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//}

package lesson11.Helper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DatabaseUtil {
    Connection connection = null;
    
    public DatabaseUtil() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return;
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://codedidungso.me:3307/MaiQuangMinh", "root", "100000");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            System.out.println("Executing query: " + query);
            ResultSet rs = stmt.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean updateQuery(String query) {
        try {
            Statement stmt = connection.createStatement();
            System.out.println("Executing query: " + query);
            stmt.execute(query);
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean closeConnection() {
        try {
            connection.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}