/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bl;

import domain.Arista;
import domain.Ruta;
import domain.Vertice;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
    
    public boolean esAdyacente(Vertice n1,Vertice n2){
        boolean aux = false;
        ArrayList<Ruta> listaAristas = n1.getListaDestinos();
        if(listaAristas != null){
            for(int i = 0;i < listaAristas.size();i++){
                if(listaAristas.get(i).getVertice() == n2){
                    aux = true;
                }
            }
        }
        return aux;
    }
    
    public Arista getArista(Vertice n1,Vertice n2){
        Arista aux = null;
        if(esAdyacente(n1, n2)){
            ArrayList<Ruta> listaAristas = n1.getListaDestinos();
            for(int i = 0;i < listaAristas.size();i++){
                if(listaAristas.get(i).getVertice() == n2){
                    aux = listaAristas.get(i).getArista();
                }
            }
        }else if(esAdyacente(n2, n1)){
            aux = getArista(n2, n1);
        }
        return aux;
    }
    
    public void reiniciarAlgoritmo(){
        for(Vertice v:listaVertice){
            v.setMarca(false);
            v.setVerticeAntecesorDisjktra(null);
            v.setLongitudCamino(-1);
        }
        if(listaVertice != null){
            for(Vertice vertice: listaVertice){
                ArrayList<Ruta> rta = vertice.getListaDestinos();
                if(rta != null){
                    for(Ruta ruta: rta){
                        if(ruta.getArista().isEstado()){
                            ruta.getArista().setColor(Color.BLUE);
                        }
                    }
                }
            }
        }
    }
}
