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
public class listaVertices extends ArrayList<Vertice> {
    
    public listaVertices(){
        super();
    }
    
    public Vertice buscarMenor(){
        Vertice aux = new Vertice();
        aux.setLongitudCamino(9999999);
        
        for(Vertice vertice:this){
            if(vertice.getLongitudCamino() < aux.getLongitudCamino()){
                aux = vertice;
            }
        }
        return aux;
    }
    
    public boolean seEncuentra(Vertice vertice){
        boolean resultado = false;
        for(Vertice v:this){
            if(v == vertice){
                resultado = true;
            }
        }
        return resultado;
    }
    
}
