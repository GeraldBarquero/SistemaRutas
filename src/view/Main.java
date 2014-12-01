/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JOptionPane;
import bl.Metodos;
import bl.Grafo;
import java.util.ArrayList;
/**
 *
 * @author Gerald
 */
public class Main {
        private static Grafo grafo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Metodos metodo = new Metodos();
        for (int i = 0; i < 5; i++) {
            String dato = JOptionPane.showInputDialog("Digite un dato");
            metodo.crearVertice(dato);
        }
        metodo.mostrarListaVertices();
    }
    
}
