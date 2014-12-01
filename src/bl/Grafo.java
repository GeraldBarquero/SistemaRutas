/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import domain.Vertice;
import java.util.ArrayList;

/**
 *
 * @author Gerald
 */
public class Grafo {
    private ArrayList<Vertice> listaVertice;

    public Grafo() {
        listaVertice = new ArrayList<Vertice>();
    }

    public ArrayList<Vertice> getListaVertice() {
        return listaVertice;
    }

    public void setListaVertice(ArrayList<Vertice> listaVertice) {
        this.listaVertice = listaVertice;
    }
    
    public boolean agregarVertice(Vertice vertice){
        Vertice aux = buscarVertice(vertice.getNombre());
        if(aux == null){
            listaVertice.add(vertice);
            return true;
        }else{
            return false;
        }
    }
    
    public Vertice buscarVertice(String nombre){
        Vertice aux = null;
        if(nombre !=null){
            for(Vertice vertice:listaVertice){
                if(nombre.equals(vertice.getNombre())){
                    aux = vertice;
                }
            }
        }
        return aux;
    }
}
