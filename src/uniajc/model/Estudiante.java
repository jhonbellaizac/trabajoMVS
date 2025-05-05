/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniajc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

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
    
    public static void guardarEstudiante(Estudiante nuevoEstudiante) {
        
        Connection conexion = ConexionDatabase.getConnection();
        
        String sql = "INSERT INTO estudiante (nombre, edad) VALUES (?, ?)";
        
        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            
            statement.setString(1, nuevoEstudiante.getNombre());
            statement.setInt(2, nuevoEstudiante.getEdad());
                
            // INSERT, UPDATE, DELETE
            statement.executeUpdate();
            
            // SELECT
            // statement.executeQuery();
                    
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        
    }
    
    // CRUD - Practica en casa
    // CAMILO -> 1. Crear metodo consultar todos los estudiantes // SELECT
    // 2. Crear metodo consultar estudiante por id // SELECT
    // 3. Elimnar un estudiante por id // DELETE
    // 4. Actualizar datos del estudiante por id // UPDATE
    
}