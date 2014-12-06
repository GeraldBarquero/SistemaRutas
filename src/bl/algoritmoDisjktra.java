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

/**
 *
 * @author Gerald
 */
public class algoritmoDisjktra {
    Grafo grafo;
    listaVertices lista;
    ArrayList<Arista> aux = new ArrayList<Arista>();

    public algoritmoDisjktra(Grafo grafo) {
        this.grafo = grafo;
        lista = new listaVertices();
        
    }
    
    private void llenarAdyacentes(Vertice vertice){
        if(vertice != null){
            ArrayList<Ruta> listaRutas = vertice.getListaDestinos();
            if(listaRutas != null){
                for (Ruta rta:listaRutas){
                    Vertice adyacente = rta.getVertice();
                    if(!adyacente.isMarca()){
                        if(lista.seEncuentra(vertice)){
                            int longitud = vertice.getLongitudCamino() + rta.getArista().getPeso();
                            if(adyacente.getLongitudCamino()>longitud){
                                adyacente.setLongitudCamino(longitud);
                                adyacente.setVerticeAntecesorDisjktra(vertice);
                            }
                        } else{
                            adyacente.setLongitudCamino(vertice.getLongitudCamino() + rta.getArista().getPeso());
                            adyacente.setVerticeAntecesorDisjktra(vertice);
                            lista.add(adyacente);
                        }
                    }
                }
            }
        }
    }
    
    public void ejecutar(Vertice verticeInicio){
        verticeInicio.setLongitudCamino(0);
        if(verticeInicio != null){
            lista = new listaVertices();
            lista.add(verticeInicio);
            while (!lista.isEmpty()){
                Vertice menor = lista.buscarMenor();
                menor.setMarca(true);
                lista.remove(menor);
                llenarAdyacentes(menor);
            }
        }
    }
    
    private void rutaCorta(Vertice verticeFinal){
        aux.clear();
        while(verticeFinal.getVerticeAntecesorDisjktra() != null){
            aux.add(grafo.getArista(verticeFinal, verticeFinal.getVerticeAntecesorDisjktra()));
            verticeFinal = verticeFinal.getVerticeAntecesorDisjktra();
        }
    }
    
    public void marcarRuta(Vertice verticeFinal){
        if(verticeFinal != null){
            rutaCorta(verticeFinal);
            for(int i = 0; i< aux.size(); i++){
                if(!aux.isEmpty()){
                    aux.get(i).setColor(Color.ORANGE);
                }
            }
        }
    }
    
    
}
