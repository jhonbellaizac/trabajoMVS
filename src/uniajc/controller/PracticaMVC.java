/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uniajc.controller;

import uniajc.model.ConexionDatabase;
import uniajc.model.Estudiante;
import uniajc.view.VistaEstudiante;

/**
 *
 * @author g.perezmoreno
 */
public class PracticaMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        // Crear modelo
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Ana");
        estudiante.setEdad(21);
        
         // Crear vista
        VistaEstudiante vista = new VistaEstudiante();
        
        // Crear controlador
        ControladorEstudiante controlador = new ControladorEstudiante(estudiante, vista);

        Estudiante nuevoEstudiante = new Estudiante();
        nuevoEstudiante.setNombre("Jose Maria");
        nuevoEstudiante.setEdad(45);
        
        controlador.crearEstudiante(nuevoEstudiante);
        
        // Mostrar datos iniciales
        controlador.actualizarVista();
        
        // Modificar datos a través del controlador
        controlador.setNombreEstudiante("Carlos");
        controlador.setEdadEstudiante(23);
        
        // Actualizar la vista
        controlador.actualizarVista();
        
        controlador.ListarEstudiante();
    }
  
}
