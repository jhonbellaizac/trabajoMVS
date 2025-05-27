/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package uniajc.controller;

import java.util.List;
import javax.swing.SwingUtilities;
import uniajc.model.ConexionDatabase;
import uniajc.model.Estudiante;
import uniajc.view.VistaEstudiante;
import uniajc.view.VistaEstudianteGUI;

/**
 *
 * @author g.perezmoreno
 */
public class PracticaMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Inicializamos el modelo creando un nuevo estudiante
        Estudiante estudiante = new Estudiante();
        // Inicializamos la vista
        VistaEstudiante vista = new VistaEstudiante();
        ControladorEstudiante controlador = new ControladorEstudiante(estudiante, vista);
         estudiante.setId(44);
        estudiante.setNombre("Carlos-SP");
        estudiante.setEdad(21);
        controlador.crearEstudiante(estudiante);
         controlador.removerEstudiante(40);
        controlador.removerEstudiante(43);
        controlador.actualizarEstudiante(estudiante);
        List<Estudiante> estudiantes = controlador.obtenerEstudiantes();
        vista.mostrarTodosLosEstudiantes(estudiantes);
        //Estudiante estudiante = new Estudiante();
        //VistaEstudiante vista = new VistaEstudiante(); // opcional
        //ControladorEstudiante controlador = new ControladorEstudiante(estudiante, vista);

        SwingUtilities.invokeLater(() -> {
            new VistaEstudianteGUI(controlador);
        });
        
        /* Esto es igual a una funcion lambda que se use de la siguiente manera:
        () -> {}
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VistaEstudianteGUI(controlador);
            }
        });
        */
    }

}
