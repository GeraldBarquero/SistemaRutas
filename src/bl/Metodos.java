/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import bl.Grafo;
import domain.Arista;
import domain.Vertice;
import domain.Ruta;
import java.util.ArrayList;
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
    
    public void crearArista(String nombreIni, String nombreFin, int peso){
        Vertice ini = grafo.buscarVertice(nombreIni);
        Vertice fin = grafo.buscarVertice(nombreFin);
        Arista nueva = new Arista();
        nueva.setPeso(peso);
        crearRuta(ini, fin, nueva);
    }
    
    public void crearRuta(Vertice ini, Vertice fin, Arista arista){
        crearRutaRecur(ini, fin, arista);
        crearRutaRecur(fin, ini, arista);
    }
    
    public void crearRutaRecur(Vertice ini, Vertice fin, Arista arista){
        if(ini !=null && fin !=null){
            ini.addVerticeAdyacente(arista, fin);
        }
    }
    
    public void rutasHabilitadas(String nombreBuscar){
        Vertice buscar = grafo.buscarVertice(nombreBuscar);
        ArrayList<Ruta> listAux = null;
        if(!buscar.getListaDestinos().isEmpty()){
            listAux = new ArrayList<Ruta>();
            for(Ruta ruta:buscar.getListaDestinos()){
                listAux.add(ruta);
            }
        }
        System.out.println("Destinos disponibles desde el vertice: "+nombreBuscar);
        for (Ruta listAux1 : listAux) {
            System.out.println("Vertice Destino: " + listAux1.getVertice().getNombre() + " Peso de la Arista: " + listAux1.getArista().getPeso());
        }
        
    }
    
    
}
