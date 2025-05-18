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

        // TODO code application logic here
        
        
        
        Estudiante estudiante = new Estudiante();
        VistaEstudiante vista = new VistaEstudiante(); // opcional
        ControladorEstudiante controlador = new ControladorEstudiante(estudiante, vista);
        Estudiante nuevoEstudiante = new Estudiante ();
        nuevoEstudiante.setNombre("jose arturo");
        nuevoEstudiante.setEdad(20);
        
        controlador.crearEstudiante(nuevoEstudiante);

        SwingUtilities.invokeLater(() -> {
            new VistaEstudianteGUI(controlador);
        });
        
        
    }

}
