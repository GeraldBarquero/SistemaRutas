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
    private int x;
    private int y;
    
    private int longitudCamino; //Para uso de la clase Disjktra
    private Vertice verticeAntecesorDisjktra; //Para uso de la clase Disjktra
    private boolean marca;//Para uso de la clase Disjktra

    public Vertice() {
        inicializarParaDisjktra();
    }

    public Vertice(String Nombre, int x, int y) {
        this.Nombre = Nombre;
        listaDestinos = new ArrayList<Ruta>();
        this.x = x;
        this.y = y; 
        inicializarParaDisjktra();
    }

    public int getLongitudCamino() {
        return longitudCamino;
    }

    public void setLongitudCamino(int longitudCamino) {
        this.longitudCamino = longitudCamino;
    }

    public Vertice getVerticeAntecesorDisjktra() {
        return verticeAntecesorDisjktra;
    }

    public void setVerticeAntecesorDisjktra(Vertice verticeAntecesorDisjktra) {
        this.verticeAntecesorDisjktra = verticeAntecesorDisjktra;
    }

    public boolean isMarca() {
        return marca;
    }

    public void setMarca(boolean marca) {
        this.marca = marca;
    }
    
    private void inicializarParaDisjktra(){
        longitudCamino = -1;
        verticeAntecesorDisjktra = null;
        marca = false;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public ArrayList<Ruta> getListaDestinos() {
        ArrayList<Ruta> listAristaAux = null;
        if(!listaDestinos.isEmpty()){
            listAristaAux = new ArrayList<Ruta>();
            for(Ruta rta:listaDestinos){
                if(rta.getArista().isEstado()){
                    listAristaAux.add(rta);
                }
            }
        }
        return listAristaAux;
    }
    
    public ArrayList<Ruta> listDestinos(){
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
