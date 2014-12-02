/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import javax.swing.JOptionPane;
import bl.Metodos;
import bl.Grafo;
import domain.Vertice;
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
        /*for (int i = 0; i < 5; i++) {
            String dato = JOptionPane.showInputDialog("Digite un dato");
            metodo.crearVertice(dato);
        }*/
        metodo.crearVertice("A");
        metodo.crearVertice("B");
        metodo.crearVertice("C");
        metodo.crearVertice("D");
        metodo.crearVertice("E");
        metodo.mostrarListaVertices();
        metodo.crearArista("A", "E", 5);
        metodo.crearArista("A", "D", 10);
        metodo.crearArista("B", "C", 8);
        metodo.crearArista("C", "D", 20);
        metodo.crearArista("D", "E", 17);
        metodo.rutasHabilitadas("A");
        metodo.rutasHabilitadas("B");
        metodo.rutasHabilitadas("C");
        metodo.rutasHabilitadas("D");        
        metodo.rutasHabilitadas("E");
        metodo.eliminarVertice("A");
        metodo.mostrarListaVertices();
        metodo.rutasHabilitadas("A");
        metodo.rutasHabilitadas("B");
        metodo.rutasHabilitadas("C");
        metodo.rutasHabilitadas("D");        
        metodo.rutasHabilitadas("E");
    }
    
}
