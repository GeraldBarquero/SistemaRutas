/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.util.ArrayList;

/**
 *
 * @author Gerald
 */
public class Vertice {
    private String Nombre;  //propiedad que hace referencia al nombre de cada vertice
    private ArrayList<Ruta> listaDestinos;

    public Vertice() {
    }

    public Vertice(String Nombre) {
        this.Nombre = Nombre;
        listaDestinos = new ArrayList<Ruta>();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Ruta> getListaDestinos() {
        return listaDestinos;
    }

    public void setListaDestinos(ArrayList<Ruta> listaDestinos) {
        this.listaDestinos = listaDestinos;
    }
    
    public void addVerticeAdyacente(Arista aris, Vertice vert){
        this.addVerticeAdyacenteRecur(new Ruta(aris,vert));
    }
    
    public void addVerticeAdyacenteRecur(Ruta ruta){
        listaDestinos.add(ruta);
    }
    
}
