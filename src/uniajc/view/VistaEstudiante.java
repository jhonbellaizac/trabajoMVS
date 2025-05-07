/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniajc.view;

import java.util.List;
import uniajc.model.Estudiante;

/**
 *
 * @author juana
 */
public class VistaEstudiante {
    
    public void mostrarDetallesEstudiante(String nombre, int edad) {
        System.out.println("Detalles del Estudiante:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
    
   public void mostrarTodosLosEstudiantes(List<Estudiante> estudiantes) {
    for (Estudiante e : estudiantes) {
        System.out.println("Nombre: " + e.getNombre() + ", Edad: " + e.getEdad());
    }
}
}
