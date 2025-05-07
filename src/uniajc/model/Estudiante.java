/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniajc.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juana
 */
public class Estudiante {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
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
    
   public static void insertarEstudiante(Estudiante estudiante) {
        Connection conexion = ConexionDatabase.getConnection();
        //String sql = "INSERT INTO estudiante (nombre, edad) VALUES (?, ?)";

        String sql = "CALL insertar_estudiante(?, ?)";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, estudiante.getNombre());
            statement.setInt(2, estudiante.getEdad());

            // INSERT, UPDATE, DELETE
            statement.executeUpdate();

            // SELECT
            // statement.executeQuery();
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public static List<Estudiante> obtenerTodosLosEstudiantes() {
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        //String sql = "SELECT id, nombre, edad FROM estudiante";
        String sql = "SELECT id, nombre, edad FROM get_estudiantes";

        try {
            Connection conexion = ConexionDatabase.getConnection();
            Statement stmt = conexion.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            while (resultado.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(resultado.getInt("id"));
                estudiante.setNombre(resultado.getString("nombre"));
                estudiante.setEdad(resultado.getInt("edad"));

                listaEstudiantes.add(estudiante);
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return listaEstudiantes;
    }

    public static void deleteEstudiante(int idEstudiante) {
        Connection conexion = ConexionDatabase.getConnection();
        String sql = "DELETE FROM estudiante WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setInt(1, idEstudiante);

            // INSERT, UPDATE, DELETE
            statement.executeUpdate();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public static void updateEstudiante(Estudiante estudiante) {
        Connection conexion = ConexionDatabase.getConnection();
        String sql = "UPDATE estudiante SET nombre = ?, edad = ? WHERE id = ?";

        try (PreparedStatement statement = conexion.prepareStatement(sql)) {
            statement.setString(1, estudiante.getNombre());
            statement.setInt(2, estudiante.getEdad());
            statement.setInt(3, estudiante.getId());

            // INSERT, UPDATE, DELETE
            statement.executeUpdate();

        } catch (Exception error) {
            error.printStackTrace();
        }
    }
}
    
    
    
    // CRUD - Practica en casa
    // CAMILO -> 1. Crear metodo consultar todos los estudiantes // SELECT
    // 2. Crear metodo consultar estudiante por id // SELECT
    // 3. Elimnar un estudiante por id // DELETE
    // 4. Actualizar datos del estudiante por id // UPDATE
    
