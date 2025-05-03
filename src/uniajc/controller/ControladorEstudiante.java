/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniajc.controller;

import java.util.List;
import uniajc.model.Estudiante;
import uniajc.view.VistaEstudiante;

/**
 *
 * @author juana
 */
public class ControladorEstudiante {
    private Estudiante modelo;
    private VistaEstudiante vista;
    
    public ControladorEstudiante(Estudiante modelo, VistaEstudiante vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
     public void setNombreEstudiante(String nombre) {
        modelo.setNombre(nombre);
    }

    public String getNombreEstudiante() {
        return modelo.getNombre();
    }

    public void setEdadEstudiante(int edad) {
        modelo.setEdad(edad);
    }

    public int getEdadEstudiante() {
        return modelo.getEdad();
    }
    
    public void crearEstudiante(Estudiante nuevoEstudiante) {
        nuevoEstudiante.guardarEstudiante(nuevoEstudiante);
        System.out.println("Nuevo estudiante guardado exitosamente!");
    }
    
    public void ListarEstudiante(){
        List<Estudiante> estudiantes = Estudiante.consultarTodos();
        vista.mostrarTodosLosEstudiantes(estudiantes);
    }
    
    // CRUD - Practica en casa
    // 1. Crear metodo consultar todos los estudiantes // SELECT
    // 2. Crear metodo consultar estudiante por id // SELECT
    // 3. Elimnar un estudiante por id // DELETE
    // 4. Actualizar nombre de estudiante por id // UPDATE
    
    public void actualizarVista() {
        vista.mostrarDetallesEstudiante(modelo.getNombre(), modelo.getEdad());
    }
}
