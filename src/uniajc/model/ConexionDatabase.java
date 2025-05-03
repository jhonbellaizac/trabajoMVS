/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniajc.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author g.perezmoreno
 */
public class ConexionDatabase {
 
    private static Connection conexion = null;
    
    public static Connection getConnection() {
        if (conexion == null) {      
            try {
                
                Properties props = new Properties();
                
                props.load(new FileInputStream("db.properties"));
                
                String url = props.getProperty("db.url");
                String user = props.getProperty("db.user");
                String password = props.getProperty("db.password");

                conexion = DriverManager.getConnection(url, user, password);
                System.out.println("Conexion exitosa!");
                System.out.println("");
            } catch (SQLException | IOException error){
                System.out.println("Error conectando a la base de datos: " + error);
            }   
        }
        return conexion;
    }
    
    public static void closeConnection() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (Exception exception) {
                System.out.println("Exception cerrando la base de datos: " + exception);
                exception.printStackTrace();
            }
        }
    }
    
}
