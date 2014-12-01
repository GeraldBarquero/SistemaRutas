/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import domain.Vertice;
import bl.Grafo;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerald
 */
public class Metodos {
    Grafo grafo = new Grafo();
    public void crearVertice(String dato){
        if(dato !=null){
            Vertice nuevo = new Vertice(dato);
            if(grafo.agregarVertice(nuevo)){
                JOptionPane.showMessageDialog(null, "Se agrego correctamente el vertice");
            }
        }
    }
    
    public void mostrarListaVertices(){
        int cantVertice = grafo.getListaVertice().size();        
        for (int i=0; i<cantVertice;i++){
            System.out.println("Vertice: "+grafo.getListaVertice().get(i).getNombre());
        }
    }
    
    public void crearArista(){
        
    }
    
    
}
