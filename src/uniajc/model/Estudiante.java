/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniajc.model;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author juana
 */
public class Estudiante {
    private String nombre;
    private int edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public static void guardarEstudiante (Estudiante nuevoEstudiandte){
        
        Connection conexion =ConexionDatabase.getConnection();
        String sql = "INSERT INTO estudiante (nombre, edad) VALUES ( ? , ?)";
        
        try (PreparedStatement statament = conexion.prepareStatement(sql)){
            
            statament.setString(1, nuevoEstudiandte.getNombre());
            statament.setInt(2, nuevoEstudiandte.getEdad());
            
            System.out.println("SQL: " + sql);
            
            statament.executeUpdate();
          
            
        }catch (Exception excepcion){
            excepcion.printStackTrace();
            
        }
        
    }    
    
}
