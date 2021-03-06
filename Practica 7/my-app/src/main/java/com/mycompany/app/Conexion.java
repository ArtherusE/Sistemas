package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.eclipse.jetty.server.Authentication.Failed;

public class Conexion {
    private static String url = "jdbc:mysql://127.0.0.1:3306/ejemplo_simple";
    private static String driverName = "com.mysql.jdbc.Driver"
    private static String username = "root";
    private static String password = "";
    private static Connection conexion = null;

    public static Connection getConexion(){
        try{
            Class.forName(driverName);
            conexion = DriverManager.getConnection(url, username, password);
            System.out.println("Sucess Connection");
        } catch(SQLException e){
            System.out.println("Failed to create Connection");
        } catch(ClassNotFoundException e){
            System.out.println("Driver not found");
        }
        return conexion;
    }
}
